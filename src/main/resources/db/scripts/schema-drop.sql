DROP VIEW IF EXISTS FactorySensorEvents;

DROP FUNCTION IF EXISTS delete_editor_func(integer);
DROP FUNCTION IF EXISTS get_longest_factory_value();
DROP FUNCTION IF EXISTS get_top_10_sensors();
DROP FUNCTION IF EXISTS check_before_insert_factories();
DROP FUNCTION IF EXISTS notify_after_delete_factories();

DROP PROCEDURE IF EXISTS insert_editor(varchar, varchar, varchar, varchar, varchar);
DROP PROCEDURE IF EXISTS delete_editor(integer);
DROP PROCEDURE IF EXISTS update_editor(integer, varchar, varchar, varchar, varchar, varchar);

DROP TABLE IF EXISTS Users_Roles;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS Users;

DROP TABLE IF EXISTS Sensors;
DROP TABLE IF EXISTS Factories;
DROP TABLE IF EXISTS Types;
DROP TABLE IF EXISTS TemperatureEvents;
DROP TABLE IF EXISTS PressureEvents;
DROP TABLE IF EXISTS GasEmissionEvents;
DROP TABLE IF EXISTS AirQualityEvents;
DROP TABLE IF EXISTS LoggingEvents;
DROP TABLE IF EXISTS Events;
DROP TABLE IF EXISTS Editors;
DROP TABLE IF EXISTS Factories_Section;
