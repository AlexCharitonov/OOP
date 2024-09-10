package org.example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * tests for class Heap.
 */
public class Test1 {
    /**
     * Test1.
     */

    @Test
    void baseTest() {
        int[] arr = Heap.heapsort(new int[] {5, 4, 3, 2, 1});
        int[] trueArr = {1, 2, 3, 4, 5};
        for (int i = 0; i < trueArr.length; i++) {
            assertEquals(trueArr[i], arr[i]);
        }
    }

    @Test
    void BigTestWithNegative() {
        Random rand = new Random();
        int n1 = 1000;
        int[] array = new int[n1];
        for (int i = 0; i < n1; i++) {
            array[i] = rand.nextInt(10000000) - 5000000;
        }
        int[] arr = Heap.heapsort(array);
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], arr[i]);
        }
    }

    @Test
    void timeTest() {
        Random rand = new Random();
        int length1 = 1000;
        int length2 = 100000;
        int length3 = 10000000;
        int[] firstArray = new int[length1];
        for (int i = 0; i < length1; i++) {
            firstArray[i] = rand.nextInt(10000000);
        }
        int[] secondArray = new int[length2];
        for (int i = 0; i < length2; i++) {
            secondArray[i] = rand.nextInt(10000000);
        }
        int[] thirdArray = new int[length3];
        for (int i = 0; i < length3; i++) {
            thirdArray[i] = rand.nextInt(10000000);
        }
        long startTime = System.currentTimeMillis();
        Heap.heapsort(firstArray);
        long finishTime = System.currentTimeMillis();
        long duration1 = finishTime - startTime;
        System.out.println("Массив из 1000 элементов, прошло времени, мс: " + duration1);
        startTime = System.currentTimeMillis();
        Heap.heapsort(secondArray);
        finishTime = System.currentTimeMillis();
        long duration2 = finishTime - startTime;
        System.out.println("Массив из 100000 элементов, прошло времени, мс: " + duration2);
        startTime = System.currentTimeMillis();
        Heap.heapsort(thirdArray);
        finishTime = System.currentTimeMillis();
        long duration3 = finishTime - startTime;
        System.out.println("Массив из 10000000 элементов, прошло времени, мс: " + duration3);
        double epsilon = 0.1;
        boolean isEqual1 = Math.abs((Math.log(length1) * length1) /
                (Math.log(length2) * length2) - duration1 / duration2) <= epsilon;
        boolean isEqual2 = Math.abs((Math.log(length2) * length2) /
                (Math.log(length3) * length3) - duration2 / duration3) <= epsilon;
        assert isEqual2 && isEqual1;}
}
