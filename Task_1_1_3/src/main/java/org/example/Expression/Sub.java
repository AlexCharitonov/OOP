package org.example.Expression;

/**
 * Класс, реализующий операцию вычитания.
 */
public class Sub extends Expression {
    private final Expression firstExpression;
    private final Expression secondExpression;

    public Sub(Expression first, Expression second) {
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
        System.out.print("-");
        this.getSecondExpression().print();
        System.out.print(")");
    }

    /**
     * Функция для нахождения производной.
     */
    public Expression derivative(String derVar) {
        return new Sub(this.getFirstExpression().derivative(derVar),
                this.getSecondExpression().derivative(derVar));
    }

    /**
     * Функция для нахождения значения выражения по заданным значениям переменных.
     */
    public int eval(String varVal) {
        return this.getFirstExpression().eval(varVal)
                - this.getSecondExpression().eval(varVal);
    }

    /**
     * Функция для упрощения выражения.
     */
    public Expression simplification() {
        Expression op1 = this.getFirstExpression().simplification();
        Expression op2 = this.getSecondExpression().simplification();
        if (op1.equals(op2)) {
            return new org.example.Expression.Number(0);
        }
        Sub ans = new Sub(op1, op2);
        if (!ans.hasVariables()) {
            return new Number((ans.eval(" ")));
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
        if (!(expr instanceof Sub)) {
            return false;
        }
        Sub sub = (Sub) expr;
        return this.getFirstExpression().equals(sub.getFirstExpression())
                && this.getSecondExpression().equals(sub.getSecondExpression());
    }
}
