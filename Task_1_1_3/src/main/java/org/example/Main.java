package org.example;

import java.util.Scanner;

/**
 * Программа запрышавет строку выражения, парсит её и выводит её формальное представление.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Expression: ");
        String str = in.nextLine();
        Expression expr = Parser.parse(str);
        expr.print();
        in.close();
    }
}