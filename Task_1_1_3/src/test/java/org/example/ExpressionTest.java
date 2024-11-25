package org.example;

import org.example.exception.EvalException;
import org.example.expression.Add;
import org.example.expression.Div;
import org.example.expression.Expression;
import org.example.expression.Mul;
import org.example.expression.Number;
import org.example.expression.Sub;
import org.example.expression.Variable;
import org.example.parser.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Тесты для классов наследуемых от абстрактного класса Expression.
 */
class ExpressionTest {

    @Test
    void testAddDerivative() {
        Expression expr = new Add(new Mul(new Number(5), new Variable("x")),
                new Variable("x"));
        Expression ans = new Add(new Add(new Mul(new Number(0), new Variable("x")),
                new Mul(new Number(5), new Number(1))), new Number(1));
        Assertions.assertTrue(ans.equals(expr.derivative("x")));
    }

    @Test
    void testSubDerivative() {
        Expression expr = new Sub(new Mul(new Number(5), new Variable("x")),
                new Variable("x"));
        Expression ans = new Sub(new Add(new Mul(new Number(0), new Variable("x")),
                new Mul(new Number(5), new Number(1))), new Number(1));
        Assertions.assertTrue(ans.equals(expr.derivative("x")));
    }

    @Test
    void testDivDerivative() {
        Expression expr = new Div(new Variable("x"), new Variable("y"));
        Expression ans = new Div(new Sub(new Mul(new Number(1), new Variable("y")),
                new Mul(new Variable("x"), new Number(0))), new Mul(new Variable("y"),
                new Variable("y")));
        Assertions.assertTrue(ans.equals(expr.derivative("x")));
    }

    @Test
    void testDerivative() {
        Expression expr = new Mul(new Mul(new Mul(new Mul(new Variable("x"), new Variable("x")),
                new Mul(new Variable("x"), new Variable("x"))),
                new Mul(new Mul(new Variable("x"), new Variable("x")),
                new Mul(new Variable("x"), new Variable("x")))),
                new Mul(new Variable("x"), new Variable("x")));
        Expression ans = new Mul(new Number(9), new Variable("x"));
        Assertions.assertTrue(ans.equals(expr.derivative("x").simplification()));
    }

    @Test
    void testIncorrectEval() {
        try {
            Expression expr = Parser.parse("x * y + z - T");
            expr.eval("x = 3");
            Assertions.fail();
        } catch (EvalException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void testCorrectEval() {
        Expression expr = Parser.parse("x * 16 + 45 - x");
        int ev = expr.eval("x = 3");
        Assertions.assertEquals(ev, 90);
    }

    @Test
    void testSimplification() {
        Expression expr = Parser.parse("(((0 + 13223 - 3) * (1 + 1 * (x * (3 - 3)))) / 1)/x");
        Expression simply = new Div(new Number(13220), new Variable("x"));
        Assertions.assertTrue(expr.simplification().equals(simply));
    }

    @Test
    void testSimplificationDiv0() {
        Expression expr = Parser.parse("(((0) * (1 + (x * (3 - 3) * 1))) / 1)/x");
        Expression simply = new Number(0);
        Assertions.assertTrue(expr.simplification().equals(simply));
    }
}