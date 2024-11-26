package org.example.exception;

/**
 * Исключение при ошибке в парсере.
 */
public class ParserException extends RuntimeException {
    public ParserException(String message) {
        super(message);
    }
}