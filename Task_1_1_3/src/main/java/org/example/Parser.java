package org.example;

import java.util.Stack;

/**
 * Класс для преобразования строки в выражение.
 */
public class Parser {
    /**
     * Функция для преобразования строки в выражение.
     * Если строка некоректная или произошла ошибка во время обработки выкидывает исключение.
     */
    public static Expression parse(String expr) {
        try {
            String str = expr.replaceAll(" ", "");

            Stack<Expression> stackExpr = new Stack<Expression>();
            Stack<String> stackOp = new Stack<String>();

            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    int start = i;
                    while (i < str.length() && Character.isDigit(str.charAt(i))) {
                        i++;
                    }
                    stackExpr.push(new Number(Integer.parseInt((str.substring(start, i)))));
                    i--;
                } else if (Character.isLetter(str.charAt(i))) {
                    int start = i;
                    while (i < str.length() && Character.isLetter(str.charAt(i))) {
                        i++;
                    }
                    stackExpr.push(new Variable(str.substring(start, i)));
                    i--;
                } else if (str.charAt(i) == '(') {
                    stackOp.push("(");
                } else if (str.charAt(i) == ')') {
                    while (true) {
                        String op = stackOp.pop();
                        if (op.equals("(")) {
                            break;
                        } else {
                            Expression expr2 = stackExpr.pop();
                            Expression expr1 = stackExpr.pop();
                            if (op.equals("+")) {
                                stackExpr.push(new Add(expr1, expr2));
                            } else if (op.equals("-")) {
                                stackExpr.push(new Sub(expr1, expr2));
                            } else if (op.equals("*")) {
                                stackExpr.push(new Mul(expr1, expr2));
                            } else if (op.equals("/")) {
                                stackExpr.push(new Div(expr1, expr2));
                            }
                        }
                    }
                } else if (str.charAt(i) == '*') {
                    if (!(stackOp.empty()
                            || stackOp.peek().equals("(")
                            || stackOp.peek().equals("+")
                            || stackOp.peek().equals("-"))) {
                        Expression expr2 = stackExpr.pop();
                        Expression expr1 = stackExpr.pop();
                        String op = stackOp.pop();
                        stackExpr.push(getExprByOp(op, expr1, expr2));
                    }
                    stackOp.push("*");
                } else if (str.charAt(i) == '/') {
                    if (!(stackOp.empty()
                            || stackOp.peek().equals("(")
                            || stackOp.peek().equals("+")
                            || stackOp.peek().equals("-"))) {
                        Expression expr2 = stackExpr.pop();
                        Expression expr1 = stackExpr.pop();
                        String op = stackOp.pop();
                        stackExpr.push(getExprByOp(op, expr1, expr2));
                    }
                    stackOp.push("/");
                } else if (str.charAt(i) == '+') {
                    while (!(stackOp.empty()
                            || stackOp.peek().equals("("))) {
                        Expression expr2 = stackExpr.pop();
                        Expression expr1 = stackExpr.pop();
                        String op = stackOp.pop();
                        stackExpr.push(getExprByOp(op, expr1, expr2));
                    }
                    stackOp.push("+");
                } else if (str.charAt(i) == '-') {
                    while (!(stackOp.empty()
                            || stackOp.peek().equals("("))) {
                        Expression expr2 = stackExpr.pop();
                        Expression expr1 = stackExpr.pop();
                        String op = stackOp.pop();
                        stackExpr.push(getExprByOp(op, expr1, expr2));
                    }
                    stackOp.push("-");
                }
            }
            while (!stackOp.empty()) {
                String op = stackOp.pop();
                Expression expr2 = stackExpr.pop();
                Expression expr1 = stackExpr.pop();
                stackExpr.push(getExprByOp(op, expr1, expr2));
            }
            if (stackExpr.size() != 1) {
                throw new Exception();
            }
            return stackExpr.pop();
        } catch (Exception e) {
            throw new ParserException("Parse failed");
        }

    }

    /**
     * Функция для создания выражения по операции и двум выражениям.
     */
    private static Expression getExprByOp(String op, Expression expr1, Expression expr2) {
        try {
            Expression ans;
            if (op.equals("+")) {
                ans = new Add(expr1, expr2);
            } else if (op.equals("-")) {
                ans = new Sub(expr1, expr2);
            } else if (op.equals("*")) {
                ans = new Mul(expr1, expr2);
            } else if (op.equals("/")) {
                ans = new Div(expr1, expr2);
            } else {
                throw new Exception();
            }
            return ans;
        } catch (Exception e) {
            throw new ParserException("Parse failed");
        }
    }
}