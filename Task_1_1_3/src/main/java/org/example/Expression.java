package org.example;

/**
 * Класс, являющийся шаблоном для математических выражений.
 * Также реализует функция парсинга выражения из строки
 */
public abstract class Expression implements Cloneable {
    /**
     * Функция для вывода на экран.
     */
    public abstract void print();

    /**
     * Функция для нахождения производной
     */
    public abstract Expression derivative(String derVar);


    /**
     * Функция для нахождения значения выражения по заданным значениям переменных.
     */
    public abstract int eval(String varVal);

    /**
     * Функция для упрощения выражения.
     */
    public abstract Expression simplification();

    /**
     * Функция для проверки наличия переменных в выражение.
     */
    public abstract boolean hasVars();

    /**
     * Функция для проверки что выражения одинаковые.
     */
    public abstract boolean equals(Expression expr);

    /**
     * Функция для клонирования выражения.
     */
    public Expression clone() {
        try {
            return (Expression) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}