package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String args [])
    {
        Random rand = new Random();
        int n1 = 10;
        int[] array = new int[n1];
        for (int i = 0; i < n1; i++) {
            array[i] = rand.nextInt(10000000) - 5000000;
        }
        int[] arr = Heap.heapsort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arr));
    }
}