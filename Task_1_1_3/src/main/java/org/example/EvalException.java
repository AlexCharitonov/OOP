package org.example;

/**
 * Исключение при ошибке в вычисление значения по заданным переменным.
 */
public class EvalException extends RuntimeException {
    public EvalException(String message) {
        super(message);
    }
}