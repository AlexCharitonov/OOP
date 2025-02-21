package org.example;

/**
 Однопоточное решение задачи нахождения составного числа в массиве.
 */
public class SequentialCheck {

    /**
     решение задачи.
     */
    public static boolean checkCompositeNumbers(int[] numbers) {
        for (int number : numbers) {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}