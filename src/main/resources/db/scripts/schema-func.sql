-- Создание табличной функции
CREATE OR REPLACE FUNCTION get_top_10_sensors()
    RETURNS TABLE
        (
            sensor_id INT,
            type_id INT,
            location VARCHAR,
            factory_id INT,
            install_date DATE,
            editor_id INT,
            event_id INT
        )
AS $$
    BEGIN
        RETURN QUERY
        SELECT
            s.id AS sensor_id,
            s.type_id,
            s.location,
            s.factory_id,
            s.install_date,
            s.editor_id,
            s.event_id
        FROM Sensors s
        ORDER BY s.type_id DESC
            LIMIT 10;
    END;
$$ LANGUAGE plpgsql;

-- Создание скалярной функции
CREATE OR REPLACE FUNCTION get_longest_factory_value()
    RETURNS VARCHAR
AS $$
    DECLARE
        longest_value VARCHAR;
    BEGIN
        SELECT name INTO longest_value FROM Factories
        ORDER BY LENGTH(name) DESC
        LIMIT 1;

        RETURN longest_value;
    END;
$$ LANGUAGE plpgsql;

-- Создание представления
CREATE OR REPLACE VIEW FactorySensorEvents AS
SELECT
    f.name AS factory_name,
    f.location AS factory_location,
    s.location AS sensor_location,
    t.name AS sensor_type,
    e.time AS event_time,
    te.temperature AS event_temperature,
    pe.pressure AS event_pressure,
    ge.gas_emission AS event_gas_emission,
    ae.air_quality AS event_air_quality,
    le.logging_level AS event_logging_level,

    -- Вычисляемый столбец: объединение sensor_location и logging_level
    CONCAT(s.location, ' - ', le.logging_level) AS zone_level
FROM
    Factories f
    JOIN Sensors s ON f.id = s.factory_id
    JOIN Types t ON s.type_id = t.id
    JOIN Events e ON s.event_id = e.id
    LEFT JOIN TemperatureEvents te ON e.id = te.id
    LEFT JOIN PressureEvents pe ON e.id = pe.id
    LEFT JOIN GasEmissionEvents ge ON e.id = ge.id
    LEFT JOIN AirQualityEvents ae ON e.id = ae.id
    LEFT JOIN LoggingEvents le ON e.id = le.id;

-- Процедура вставки данных в таблицу Editors
CREATE OR REPLACE PROCEDURE insert_editor(
    p_last_name VARCHAR(255),
    p_first_name VARCHAR(255),
    p_middle_name VARCHAR(255),
    p_post VARCHAR(255),
    p_phone_number VARCHAR(20)
) AS $$
    BEGIN
        INSERT INTO Editors (last_name, first_name, middle_name, post, phone_number)
        VALUES (p_last_name, p_first_name, p_middle_name, p_post, p_phone_number);
    END;
$$ LANGUAGE plpgsql;

-- Процедура для обновления данных в таблице Editors
CREATE OR REPLACE PROCEDURE update_editor(
    p_id INT,
    p_last_name VARCHAR(255),
    p_first_name VARCHAR(255),
    p_middle_name VARCHAR(255),
    p_post VARCHAR(255),
    p_phone_number VARCHAR(20)
) AS $$
    BEGIN
        UPDATE Editors
        SET
            last_name = p_last_name,
            first_name = p_first_name,
            middle_name = p_middle_name,
            post = p_post,
            phone_number = p_phone_number
        WHERE id = p_id;
    END;
$$ LANGUAGE plpgsql;

-- Процедура для удаления записи из таблицы Editors
CREATE OR REPLACE PROCEDURE delete_editor(p_id INT)
AS $$
    BEGIN
        DELETE FROM Editors WHERE id = p_id;
    END;
$$ LANGUAGE plpgsql;

-- Функция проверки уровня логирования при добавлении записи в таблицу Events
CREATE OR REPLACE FUNCTION check_error_logging()
    RETURNS TRIGGER
AS $$
    BEGIN
        -- Проверяем, если уровень логирования события равен 'ERROR'
        IF EXISTS (SELECT 1 FROM LoggingEvents
                   WHERE id = NEW.id AND logging_level = 'ERROR') THEN
            RAISE NOTICE
                'Критический уровень опасности для события с ID: %, требуется проверка места положения датчика.', NEW.id;
        END IF;
        RETURN NEW;
    END;
$$ LANGUAGE plpgsql;

-- Тригер After
CREATE TRIGGER after_event_insert
    AFTER INSERT ON Events
    FOR EACH ROW
EXECUTE FUNCTION check_error_logging();
