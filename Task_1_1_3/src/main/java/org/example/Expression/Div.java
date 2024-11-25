package org.example.Expression;

/**
 * Класс, реализующий операцию деления.
 */
public class Div extends Expression {
    private final Expression firstExpression;
    private final Expression secondExpression;

    public Div(Expression first, Expression second) {
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
        System.out.print("/");
        this.getSecondExpression().print();
        System.out.print(")");
    }

    /**
     * Функция для нахождения производной.
     */
    public Expression derivative(String derVar) {
        return new Div(new Sub(new Mul(this.getFirstExpression().derivative(derVar),
                this.getSecondExpression()), new Mul(this.getFirstExpression(),
                this.getSecondExpression().derivative(derVar))),
                new Mul(this.getSecondExpression(), this.getSecondExpression()));
    }

    /**
     * Функция для нахождения значения выражения по заданным значениям переменных.
     */
    public int eval(String varVal) {
        return this.getFirstExpression().eval(varVal) / this.getSecondExpression().eval(varVal);
    }

    /**
     * Функция для упрощения выражения.
     */
    public Expression simplification() {
        Expression op1 = this.getFirstExpression().simplification();
        Expression op2 = this.getSecondExpression().simplification();
        if (op1 instanceof Number && op1.eval(" ") == 0) {
            return new Number(0);
        } else if (op2 instanceof Number && op2.eval(" ") == 1) {
            return op1;
        }
        Div ans = new Div(op1, op2);
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
        if (!(expr instanceof Div)) {
            return false;
        }
        Div div = (Div) expr;
        return this.getFirstExpression().equals(div.getFirstExpression())
                && this.getSecondExpression().equals(div.getSecondExpression());
    }
}
