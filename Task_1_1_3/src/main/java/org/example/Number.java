package org.example;

/**
 * Класс, реализующий число.
 */
public class Number extends Expression {
    private String num;

    public Number(int number) {
        num = String.valueOf(number);
    }

    /**
     * Функция для вывода на экран.
     */
    public void print() {
        if (Integer.parseInt(num) < 0) {
            System.out.print("(" + num + ")");
        } else {
            System.out.print(num);
        }
    }

    /**
     * Функция для нахождения производной.
     */
    public Expression derivative(String derVar) {
        return new Number(0);
    }

    /**
     * Функция для нахождения значения выражения по заданным значениям переменных.
     */
    public int eval(String varVal) {
        return Integer.parseInt(num);
    }

    /**
     * Функция для упрощения выражения.
     */
    public Expression simplification() {
        return this.clone();
    }

    /**
     * Функция для проверки наличия переменных в выражение.
     */
    public boolean hasVariables() {
        return false;
    }

    /**
     * Функция для проверки что выражения одинаковые.
     */
    public boolean equals(Expression expr) {
        if (!(expr instanceof Number)) {
            return false;
        }

        Number number = (Number) expr;
        return num.equals(number.num);
    }
}
