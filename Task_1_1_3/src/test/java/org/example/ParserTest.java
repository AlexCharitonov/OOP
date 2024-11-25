package org.example;

import org.example.Expression.*;
import org.example.Expression.Number;
import org.example.exception.ParserException;
import org.example.parser.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Тесты для класса Parser.
 */
public class ParserTest {

    @Test
    void testParseCorrectString() {
        Expression expr = Parser.parse("367254 + (456)*(X-43*y)    / 456");
        Expression ans = new Add(new org.example.Expression.Number(367254),
                new Div(new Mul(new org.example.Expression.Number(456), new Sub(new Variable("X"),
                        new Mul(new org.example.Expression.Number(43), new Variable("y")))), new Number(456)));
        Assertions.assertTrue(expr.equals(ans));
    }

    @Test
    void testParseIncorrectString() {
        try {
            Expression expr = Parser.parse("(34 + 57 / (34 + 57 /    (47) + 63)");
            Assertions.fail();
        } catch (ParserException e) {
            Assertions.assertTrue(true);
        }
    }
}
