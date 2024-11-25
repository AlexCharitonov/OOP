package org.example;

import org.example.expression.Expression;
import org.example.parser.Parser;
import java.util.Scanner;

/**
 * Класс содержащий main.
 */
public class Main {

    /**
     * Программа запрышавет строку выражения, парсит её и выводит её формальное представление.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Expression: ");
        String str = in.nextLine();
        Expression expr = Parser.parse(str);
        expr.print();
        Expression simply = expr.simplification();
        simply.print();
        in.close();
    }
}