package org.example;

/**
 * Класс, реализующий операцию сложения.
 */
public class Add extends Expression {
    private final Expression firstExpression;
    private final Expression secondExpression;

    public Add(Expression first, Expression second) {
        firstExpression = first.clone();
        secondExpression = second.clone();
    }

    /**
     * Функция для получения первого выражения.
     */
    Expression getFirstExpression() {
        return firstExpression.clone();
    }

    /**
     * Функция для получения второго выражения.
     */
    Expression getSecondExpression() {
        return secondExpression.clone();
    }

    /**
     * Функция для вывода на экран.
     */
    public void print() {
        System.out.print("(");
        this.getFirstExpression().print();
        System.out.print("+");
        this.getSecondExpression().print();
        System.out.print(")");
    }

    /**
     * Функция для нахождения производной.
     */
    public Expression derivative(String derVar) {
        return new Add(this.getFirstExpression().derivative(derVar),
                this.getSecondExpression().derivative(derVar));
    }

    /**
     * Функция для нахождения значения выражения по заданным значениям переменных.
     */
    public int eval(String varVal) {
        return this.getFirstExpression().eval(varVal)
                + this.getSecondExpression().eval(varVal);
    }

    /**
     * Функция для упрощения выражения.
     */
    public Expression simplification() {
        if (!hasVariables()) {
            return new Number(eval(" "));
        }
        Expression ans = new Add(this.getFirstExpression().simplification(),
                this.getSecondExpression().simplification());
        if (!ans.hasVariables()) {
            return new Number(ans.eval(" "));
        }

        return ans;
    }

    /**
     * Функция для проверки наличия переменных в выражение.
     */
    public boolean hasVariables() {
        return this.getFirstExpression().hasVariables()
                || this.getSecondExpression().hasVariables();
    }

    /**
     * Функция для проверки что выражения одинаковые.
     */
    public boolean equals(Expression expr) {
        if (!(expr instanceof Add)) {
            return false;
        }
        Add add = (Add) expr;
        return this.getFirstExpression().equals(add.getFirstExpression())
                && this.getSecondExpression().equals(add.getSecondExpression());
    }
}
