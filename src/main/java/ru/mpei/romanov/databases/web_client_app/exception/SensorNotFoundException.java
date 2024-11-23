package ru.mpei.romanov.databases.web_client_app.exception;

public class SensorNotFoundException extends RuntimeException {
    public SensorNotFoundException(String name) {
        super(name);
    }
}
