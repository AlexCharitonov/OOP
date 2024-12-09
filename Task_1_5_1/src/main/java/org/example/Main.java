package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str = "asdfasdf";
        String str1 = String.format("%10s",str);
        String str2 = String.format("%-10s",str);
        String str3 = String.format("%6s",str);
        System.out.print(str);
        System.out.print(str1);
        System.out.print(str2);
        System.out.print(str3);
    }
}