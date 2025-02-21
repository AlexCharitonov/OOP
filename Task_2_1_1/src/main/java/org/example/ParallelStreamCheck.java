package org.example;

import java.util.Arrays;
import java.util.List;

/**
 Решение задачи через parallelStream.
 */
public class ParallelStreamCheck{

    /**
     решение задачи.
     */
    public static boolean checkCompositeNumbers(Integer[] numbers) {
        List<Integer> list = Arrays.asList(numbers);
        return list.parallelStream().anyMatch(ParallelStreamCheck::isComposite);
    }

    /**
     проверка на НЕ простоту.
     */
    private static boolean isComposite(int number) {
        for (int i = 2; i * i < number; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}