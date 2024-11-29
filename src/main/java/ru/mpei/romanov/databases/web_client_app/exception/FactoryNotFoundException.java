package ru.mpei.romanov.databases.web_client_app.exception;

public class FactoryNotFoundException extends RuntimeException {
    public FactoryNotFoundException(String name) {
        super(name);
    }
}
