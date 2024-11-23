-- Таблица ролей
CREATE TABLE IF NOT EXISTS Roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Таблица пользователей
CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Таблица связи пользователя и роли
CREATE TABLE IF NOT EXISTS Users_Roles (
    user_id BIGINT,
    role_id BIGINT,

    CONSTRAINT fk_users_user_id FOREIGN KEY (user_id)
        REFERENCES Users (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_roles_role_id FOREIGN KEY (role_id)
        REFERENCES Roles (id)
        ON DELETE CASCADE
);

-- Таблица заводов
CREATE TABLE IF NOT EXISTS Factories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

-- Таблица типов датчиков
CREATE TABLE IF NOT EXISTS Types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Таблица событий
CREATE TABLE IF NOT EXISTS Events (
    id SERIAL PRIMARY KEY,
    time TIMESTAMP NOT NULL
);

-- Таблица температурных данных
CREATE TABLE IF NOT EXISTS TemperatureEvents (
    id SERIAL PRIMARY KEY,
    temperature DECIMAL(5, 2) NOT NULL,

    CONSTRAINT fk_event_temperature FOREIGN KEY (id)
        REFERENCES Events (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Таблица данных давления
CREATE TABLE IF NOT EXISTS PressureEvents (
    id SERIAL PRIMARY KEY,
    pressure DECIMAL(7, 2) NOT NULL,

    CONSTRAINT fk_event_pressure FOREIGN KEY (id)
        REFERENCES Events (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Таблица данных газовых выбросов
CREATE TABLE IF NOT EXISTS GasEmissionEvents (
    id SERIAL PRIMARY KEY,
    gas_emission DECIMAL(5, 2) NOT NULL,

    CONSTRAINT fk_event_gas_emission FOREIGN KEY (id)
        REFERENCES Events (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Таблица данных качества воздуха
CREATE TABLE IF NOT EXISTS AirQualityEvents (
    id SERIAL PRIMARY KEY,
    air_quality DECIMAL(5, 2) NOT NULL,

    CONSTRAINT fk_event_air_quality FOREIGN KEY (id)
        REFERENCES Events (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Таблица данных логирования
CREATE TABLE IF NOT EXISTS LoggingEvents (
    id SERIAL PRIMARY KEY,
    logging_level VARCHAR(50) NOT NULL,

    CONSTRAINT fk_event_logging_level FOREIGN KEY (id)
        REFERENCES Events (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Таблица редакторов
CREATE TABLE IF NOT EXISTS Editors (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    post VARCHAR(255),
    phone_number VARCHAR(20)
);

-- Таблица датчиков
CREATE TABLE IF NOT EXISTS Sensors (
    id SERIAL PRIMARY KEY,
    type_id INT NOT NULL,
    location VARCHAR(255) NOT NULL,
    factory_id INT,
    install_date DATE,
    editor_id INT,
    event_id INT,

    -- Внешние ключи
    CONSTRAINT fk_type FOREIGN KEY (type_id)
        REFERENCES Types (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_factory FOREIGN KEY (factory_id)
        REFERENCES Factories (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_editor FOREIGN KEY (editor_id)
        REFERENCES Editors (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT fk_event FOREIGN KEY (event_id)
        REFERENCES Events (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
