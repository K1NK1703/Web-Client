package ru.mpei.romanov.databases.web_client_app.exception;

public class TypeNotFoundException extends RuntimeException {
    public TypeNotFoundException(String name) {
        super(name);
    }
}
