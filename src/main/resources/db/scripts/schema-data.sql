-- Вставка данных в таблицу Roles
INSERT INTO Roles (name)
SELECT 'ROLE_ADMIN'
WHERE NOT EXISTS(SELECT 1 FROM Roles)
UNION ALL
SELECT 'ROLE_USER'
WHERE NOT EXISTS(SELECT 1 FROM Roles);

-- Вставка данных в таблицу Users
INSERT INTO Users (username, password)
SELECT 'admin', '$2a$12$G6Ba1FSzXZCdXjwsdafnT.nhxU8vygYOyUzVmXLfqwjqj4klnno32'
WHERE NOT EXISTS (SELECT 1 FROM Users WHERE username = 'admin')
UNION ALL
SELECT 'user', '$2a$12$G6Ba1FSzXZCdXjwsdafnT.nhxU8vygYOyUzVmXLfqwjqj4klnno32'
WHERE NOT EXISTS (SELECT 1 FROM Users WHERE username = 'user');

-- Вставка данных в таблицу Users_Roles
INSERT INTO Users_Roles (user_id, role_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT 1 FROM Users_Roles WHERE user_id = 1 AND role_id = 1)
UNION ALL
SELECT 1, 2
WHERE NOT EXISTS (SELECT 1 FROM Users_Roles WHERE user_id = 1 AND role_id = 2)
UNION ALL
SELECT 2, 2
WHERE NOT EXISTS (SELECT 1 FROM Users_Roles WHERE user_id = 2 AND role_id = 2);

-- Вставка данных в таблицу Factories
INSERT INTO Factories (name, location)
SELECT 'Factory A', 'Location 1'
WHERE NOT EXISTS (SELECT 1 FROM Factories WHERE name = 'Factory A' AND location = 'Location 1')
UNION ALL
SELECT 'Factory B', 'Location 2'
WHERE NOT EXISTS (SELECT 1 FROM Factories WHERE name = 'Factory B' AND location = 'Location 2')
UNION ALL
SELECT 'Factory C', 'Location 3'
WHERE NOT EXISTS (SELECT 1 FROM Factories WHERE name = 'Factory C' AND location = 'Location 3')
UNION ALL
SELECT 'Factory D', 'Location 4'
WHERE NOT EXISTS (SELECT 1 FROM Factories WHERE name = 'Factory D' AND location = 'Location 4')
UNION ALL
SELECT 'Factory E', 'Location 5'
WHERE NOT EXISTS (SELECT 1 FROM Factories WHERE name = 'Factory E' AND location = 'Location 5')
UNION ALL
SELECT 'Factory F', 'Location 6'
WHERE NOT EXISTS (SELECT 1 FROM Factories WHERE name = 'Factory F' AND location = 'Location 6')
UNION ALL
SELECT 'Factory G', 'Location 7'
WHERE NOT EXISTS (SELECT 1 FROM Factories WHERE name = 'Factory G' AND location = 'Location 7');

-- Вставка данных в таблицу Types
INSERT INTO Types (name)
SELECT 'Temperature Sensor'
WHERE NOT EXISTS (SELECT 1 FROM Types WHERE name = 'Temperature Sensor')
UNION ALL
SELECT 'Pressure Sensor'
WHERE NOT EXISTS (SELECT 1 FROM Types WHERE name = 'Pressure Sensor')
UNION ALL
SELECT 'Level Sensor'
WHERE NOT EXISTS (SELECT 1 FROM Types WHERE name = 'Level Sensor')
UNION ALL
SELECT 'Presence Sensor'
WHERE NOT EXISTS (SELECT 1 FROM Types WHERE name = 'Presence Sensor')
UNION ALL
SELECT 'Gas Emission Sensor'
WHERE NOT EXISTS (SELECT 1 FROM Types WHERE name = 'Gas Emission Sensor')
UNION ALL
SELECT 'Air Quality Sensor'
WHERE NOT EXISTS (SELECT 1 FROM Types WHERE name = 'Air Quality Sensor')
UNION ALL
SELECT 'Vibration Sensor'
WHERE NOT EXISTS (SELECT 1 FROM Types WHERE name = 'Vibration Sensor');

-- Вставка данных в таблицу Events
INSERT INTO Events (time)
SELECT '2024-11-15 10:00:00'::timestamp
WHERE NOT EXISTS (SELECT 1 FROM Events WHERE time = '2024-11-15 10:00:00'::timestamp)
UNION ALL
SELECT '2024-11-15 11:00:00'::timestamp
WHERE NOT EXISTS (SELECT 1 FROM Events WHERE time = '2024-11-15 11:00:00'::timestamp)
UNION ALL
SELECT '2024-11-15 12:00:00'::timestamp
WHERE NOT EXISTS (SELECT 1 FROM Events WHERE time = '2024-11-15 12:00:00'::timestamp)
UNION ALL
SELECT '2024-11-15 13:00:00'::timestamp
WHERE NOT EXISTS (SELECT 1 FROM Events WHERE time = '2024-11-15 13:00:00'::timestamp)
UNION ALL
SELECT '2024-11-15 14:00:00'::timestamp
WHERE NOT EXISTS (SELECT 1 FROM Events WHERE time = '2024-11-15 14:00:00'::timestamp)
UNION ALL
SELECT '2024-11-15 15:00:00'::timestamp
WHERE NOT EXISTS (SELECT 1 FROM Events WHERE time = '2024-11-15 15:00:00'::timestamp)
UNION ALL
SELECT '2024-11-15 16:00:00'::timestamp
WHERE NOT EXISTS (SELECT 1 FROM Events WHERE time = '2024-11-15 16:00:00'::timestamp);

-- Вставка данных в таблицу TemperatureEvents
INSERT INTO TemperatureEvents (temperature)
SELECT 20.5
WHERE NOT EXISTS (SELECT 1 FROM TemperatureEvents WHERE temperature = 20.5)
UNION ALL
SELECT 22.3
WHERE NOT EXISTS (SELECT 1 FROM TemperatureEvents WHERE temperature = 22.3)
UNION ALL
SELECT 21.8
WHERE NOT EXISTS (SELECT 1 FROM TemperatureEvents WHERE temperature = 21.8)
UNION ALL
SELECT 19.7
WHERE NOT EXISTS (SELECT 1 FROM TemperatureEvents WHERE temperature = 19.7)
UNION ALL
SELECT 23.1
WHERE NOT EXISTS (SELECT 1 FROM TemperatureEvents WHERE temperature = 23.1)
UNION ALL
SELECT 20.9
WHERE NOT EXISTS (SELECT 1 FROM TemperatureEvents WHERE temperature = 20.9)
UNION ALL
SELECT 18.4
WHERE NOT EXISTS (SELECT 1 FROM TemperatureEvents WHERE temperature = 18.4);

-- Вставка данных в таблицу PressureEvents
INSERT INTO PressureEvents (pressure)
SELECT 1013.25
WHERE NOT EXISTS (SELECT 1 FROM PressureEvents WHERE pressure = 1013.25)
UNION ALL
SELECT 1012.50
WHERE NOT EXISTS (SELECT 1 FROM PressureEvents WHERE pressure = 1012.50)
UNION ALL
SELECT 1014.00
WHERE NOT EXISTS (SELECT 1 FROM PressureEvents WHERE pressure = 1014.00)
UNION ALL
SELECT 1011.75
WHERE NOT EXISTS (SELECT 1 FROM PressureEvents WHERE pressure = 1011.75)
UNION ALL
SELECT 1013.00
WHERE NOT EXISTS (SELECT 1 FROM PressureEvents WHERE pressure = 1013.00)
UNION ALL
SELECT 1012.80
WHERE NOT EXISTS (SELECT 1 FROM PressureEvents WHERE pressure = 1012.80)
UNION ALL
SELECT 1011.90
WHERE NOT EXISTS (SELECT 1 FROM PressureEvents WHERE pressure = 1011.90);

-- Вставка данных в таблицу GasEmissionEvents
INSERT INTO GasEmissionEvents (gas_emission)
SELECT 0.05
WHERE NOT EXISTS (SELECT 1 FROM GasEmissionEvents WHERE gas_emission = 0.05)
UNION ALL
SELECT 0.08
WHERE NOT EXISTS (SELECT 1 FROM GasEmissionEvents WHERE gas_emission = 0.08)
UNION ALL
SELECT 0.04
WHERE NOT EXISTS (SELECT 1 FROM GasEmissionEvents WHERE gas_emission = 0.04)
UNION ALL
SELECT 0.07
WHERE NOT EXISTS (SELECT 1 FROM GasEmissionEvents WHERE gas_emission = 0.07)
UNION ALL
SELECT 0.06
WHERE NOT EXISTS (SELECT 1 FROM GasEmissionEvents WHERE gas_emission = 0.06)
UNION ALL
SELECT 0.05
WHERE NOT EXISTS (SELECT 1 FROM GasEmissionEvents WHERE gas_emission = 0.05)
UNION ALL
SELECT 0.09
WHERE NOT EXISTS (SELECT 1 FROM GasEmissionEvents WHERE gas_emission = 0.09);

-- Вставка данных в таблицу AirQualityEvents
INSERT INTO AirQualityEvents (air_quality)
SELECT 85.2
WHERE NOT EXISTS (SELECT 1 FROM AirQualityEvents WHERE air_quality = 85.2)
UNION ALL
SELECT 82.5
WHERE NOT EXISTS (SELECT 1 FROM AirQualityEvents WHERE air_quality = 82.5)
UNION ALL
SELECT 88.0
WHERE NOT EXISTS (SELECT 1 FROM AirQualityEvents WHERE air_quality = 88.0)
UNION ALL
SELECT 81.7
WHERE NOT EXISTS (SELECT 1 FROM AirQualityEvents WHERE air_quality = 81.7)
UNION ALL
SELECT 86.4
WHERE NOT EXISTS (SELECT 1 FROM AirQualityEvents WHERE air_quality = 86.4)
UNION ALL
SELECT 83.6
WHERE NOT EXISTS (SELECT 1 FROM AirQualityEvents WHERE air_quality = 83.6)
UNION ALL
SELECT 80.1
WHERE NOT EXISTS (SELECT 1 FROM AirQualityEvents WHERE air_quality = 80.1);

-- Вставка данных в таблицу LoggingEvents
INSERT INTO LoggingEvents (logging_level) VALUES
    ('INFO'),
    ('WARNING'),
    ('ERROR'),
    ('DEBUG'),
    ('INFO'),
    ('WARNING'),
    ('ERROR');

-- Вставка данных в таблицу Editors
INSERT INTO Editors (last_name, first_name, middle_name, post, phone_number)
SELECT 'Smith', 'John', 'A.', 'Technician', '123-456-7890'
WHERE NOT EXISTS (SELECT 1 FROM Editors WHERE last_name = 'Smith' AND first_name = 'John' AND middle_name = 'A.' AND post = 'Technician' AND phone_number = '123-456-7890')
UNION ALL
SELECT 'Johnson', 'Mary', 'B.', 'Engineer', '234-567-8901'
WHERE NOT EXISTS (SELECT 1 FROM Editors WHERE last_name = 'Johnson' AND first_name = 'Mary' AND middle_name = 'B.' AND post = 'Engineer' AND phone_number = '234-567-8901')
UNION ALL
SELECT 'Williams', 'James', 'C.', 'Manager', '345-678-9012'
WHERE NOT EXISTS (SELECT 1 FROM Editors WHERE last_name = 'Williams' AND first_name = 'James' AND middle_name = 'C.' AND post = 'Manager' AND phone_number = '345-678-9012')
UNION ALL
SELECT 'Brown', 'Patricia', 'D.', 'Operator', '456-789-0123'
WHERE NOT EXISTS (SELECT 1 FROM Editors WHERE last_name = 'Brown' AND first_name = 'Patricia' AND middle_name = 'D.' AND post = 'Operator' AND phone_number = '456-789-0123')
UNION ALL
SELECT 'Jones', 'Robert', 'E.', 'Supervisor', '567-890-1234'
WHERE NOT EXISTS (SELECT 1 FROM Editors WHERE last_name = 'Jones' AND first_name = 'Robert' AND middle_name = 'E.' AND post = 'Supervisor' AND phone_number = '567-890-1234')
UNION ALL
SELECT 'Miller', 'Linda', 'F.', 'Analyst', '678-901-2345'
WHERE NOT EXISTS (SELECT 1 FROM Editors WHERE last_name = 'Miller' AND first_name = 'Linda' AND middle_name = 'F.' AND post = 'Analyst' AND phone_number = '678-901-2345')
UNION ALL
SELECT 'Davis', 'Michael', 'G.', 'Inspector', '789-012-3456'
WHERE NOT EXISTS (SELECT 1 FROM Editors WHERE last_name = 'Davis' AND first_name = 'Michael' AND middle_name = 'G.' AND post = 'Inspector' AND phone_number = '789-012-3456');

-- Вставка данных в таблицу Sensors
INSERT INTO Sensors (type_id, location, factory_id, install_date, editor_id, event_id)
SELECT 1, 'Zone A', 1, '2024-09-01'::DATE, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 1 AND location = 'Zone A' AND factory_id = 1 AND install_date = '2024-09-01'::DATE AND editor_id = 1 AND event_id = 1)
UNION ALL
SELECT 2, 'Zone B', 1, '2024-09-02'::DATE, 2, 2
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 2 AND location = 'Zone B' AND factory_id = 1 AND install_date = '2024-09-02'::DATE AND editor_id = 2 AND event_id = 2)
UNION ALL
SELECT 3, 'Zone C', 2, '2024-09-03'::DATE, 3, 3
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 3 AND location = 'Zone C' AND factory_id = 2 AND install_date = '2024-09-03'::DATE AND editor_id = 3 AND event_id = 3)
UNION ALL
SELECT 4, 'Zone D', 2, '2024-09-04'::DATE, 4, 4
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 4 AND location = 'Zone D' AND factory_id = 2 AND install_date = '2024-09-04'::DATE AND editor_id = 4 AND event_id = 4)
UNION ALL
SELECT 5, 'Zone E', 3, '2024-09-05'::DATE, 5, 5
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 5 AND location = 'Zone E' AND factory_id = 3 AND install_date = '2024-09-05'::DATE AND editor_id = 5 AND event_id = 5)
UNION ALL
SELECT 6, 'Zone F', 3, '2024-09-06'::DATE, 6, 6
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 6 AND location = 'Zone F' AND factory_id = 3 AND install_date = '2024-09-06'::DATE AND editor_id = 6 AND event_id = 6)
UNION ALL
SELECT 7, 'Zone G', 4, '2024-09-07'::DATE, 7, 7
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 7 AND location = 'Zone G' AND factory_id = 4 AND install_date = '2024-09-07'::DATE AND editor_id = 7 AND event_id = 7)
UNION ALL
SELECT 1, 'Zone H', 4, '2024-09-08'::DATE, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 1 AND location = 'Zone H' AND factory_id = 4 AND install_date = '2024-09-08'::DATE AND editor_id = 1 AND event_id = 1)
UNION ALL
SELECT 2, 'Zone I', 5, '2024-09-09'::DATE, 2, 2
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 2 AND location = 'Zone I' AND factory_id = 5 AND install_date = '2024-09-09'::DATE AND editor_id = 2 AND event_id = 2)
UNION ALL
SELECT 3, 'Zone J', 5, '2024-09-10'::DATE, 3, 3
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 3 AND location = 'Zone J' AND factory_id = 5 AND install_date = '2024-09-10'::DATE AND editor_id = 3 AND event_id = 3)
UNION ALL
SELECT 4, 'Zone K', 6, '2024-09-11'::DATE, 4, 4
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 4 AND location = 'Zone K' AND factory_id = 6 AND install_date = '2024-09-11'::DATE AND editor_id = 4 AND event_id = 4)
UNION ALL
SELECT 5, 'Zone L', 6, '2024-09-12'::DATE, 5, 5
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 5 AND location = 'Zone L' AND factory_id = 6 AND install_date = '2024-09-12'::DATE AND editor_id = 5 AND event_id = 5)
UNION ALL
SELECT 6, 'Zone M', 7, '2024-09-13'::DATE, 6, 6
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 6 AND location = 'Zone M' AND factory_id = 7 AND install_date = '2024-09-13'::DATE AND editor_id = 6 AND event_id = 6)
UNION ALL
SELECT 7, 'Zone N', 7, '2024-09-14'::DATE, 7, 7
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 7 AND location = 'Zone N' AND factory_id = 7 AND install_date = '2024-09-14'::DATE AND editor_id = 7 AND event_id = 7)
UNION ALL
SELECT 1, 'Zone O', 1, '2024-09-15'::DATE, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 1 AND location = 'Zone O' AND factory_id = 1 AND install_date = '2024-09-15'::DATE AND editor_id = 1 AND event_id = 1)
UNION ALL
SELECT 2, 'Zone P', 2, '2024-09-16'::DATE, 2, 2
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 2 AND location = 'Zone P' AND factory_id = 2 AND install_date = '2024-09-16'::DATE AND editor_id = 2 AND event_id = 2)
UNION ALL
SELECT 3, 'Zone Q', 3, '2024-09-17'::DATE, 3, 3
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 3 AND location = 'Zone Q' AND factory_id = 3 AND install_date = '2024-09-17'::DATE AND editor_id = 3 AND event_id = 3)
UNION ALL
SELECT 4, 'Zone R', 4, '2024-09-18'::DATE, 4, 4
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 4 AND location = 'Zone R' AND factory_id = 4 AND install_date = '2024-09-18'::DATE AND editor_id = 4 AND event_id = 4)
UNION ALL
SELECT 5, 'Zone S', 5, '2024-09-19'::DATE, 5, 5
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 5 AND location = 'Zone S' AND factory_id = 5 AND install_date = '2024-09-19'::DATE AND editor_id = 5 AND event_id = 5)
UNION ALL
SELECT 6, 'Zone T', 6, '2024-09-20'::DATE, 6, 6
WHERE NOT EXISTS (SELECT 1 FROM Sensors WHERE type_id = 6 AND location = 'Zone T' AND factory_id = 6 AND install_date = '2024-09-20'::DATE AND editor_id = 6 AND event_id = 6);
