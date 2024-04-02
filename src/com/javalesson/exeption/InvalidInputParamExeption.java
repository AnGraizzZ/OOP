package com.javalesson.exeption;

public class InvalidInputParamExeption extends RuntimeException{
    public InvalidInputParamExeption() {
    }

    public InvalidInputParamExeption(String message) {
        super(message);
    }

    public InvalidInputParamExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputParamExeption(Throwable cause) {
        super(cause);
    }
}
