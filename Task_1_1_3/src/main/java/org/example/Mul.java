package org.example;

/**
 * Класс, реализующий операцию умножения.
 */
public class Mul extends Expression {
    private final Expression firstExpression;
    private final Expression secondExpression;

    public Mul(Expression first, Expression second) {
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
        System.out.print("*");
        this.getSecondExpression().print();
        System.out.print(")");
    }

    /**
     * Функция для нахождения производной.
     */
    public Expression derivative(String derVar) {
        return new Add(new Mul(this.getFirstExpression().derivative(derVar),
                this.getSecondExpression()), new Mul(this.getFirstExpression(),
                this.getSecondExpression().derivative(derVar)));
    }

    /**
     * Функция для нахождения значения выражения по заданным значениям переменных.
     */
    public int eval(String varVal) {
        return this.getFirstExpression().eval(varVal) * this.getSecondExpression().eval(varVal);
    }

    /**
     * Функция для упрощения выражения.
     */
    public Expression simplification() {
        Expression op1 = this.getFirstExpression().simplification();
        Expression op2 = this.getSecondExpression().simplification();

        if (op1 instanceof Number && op1.eval("") == 1) {
            return op2.clone();
        } else if (op1 instanceof Number && op1.eval("") == 0) {
            return new Number(0);
        } else if (op2 instanceof Number && op2.eval("") == 1) {
            return op1.clone();
        } else if (op2 instanceof Number && op2.eval("") == 0) {
            return new Number(0);
        }

        if (!hasVariables()) {
            Mul ans = new Mul(op1, op2);
            return new Number(ans.eval(" "));
        }

        return new Mul(op1, op2);

    }

    /**
     * Функция для проверки наличия переменных в выражение.
     */
    public boolean hasVariables() {
        return this.getFirstExpression().hasVariables() || this.getSecondExpression().hasVariables();
    }

    /**
     * Функция для проверки что выражения одинаковые.
     */
    public boolean equals(Expression expr) {
        if (!(expr instanceof Mul)) {
            return false;
        }

        Mul mul = (Mul) expr;
        return this.getFirstExpression().equals(mul.getFirstExpression())
                && this.getSecondExpression().equals(mul.getSecondExpression());
    }
}
