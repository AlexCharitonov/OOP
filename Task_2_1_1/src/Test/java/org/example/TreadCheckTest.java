package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ThreadCheckTest {
    int[] array = new int[100_000_000];

    @Test
    void test1_1() {
        ThreadCheck threadCheck = new ThreadCheck();
        threadCheck.setCountOfThreads(1);
        Arrays.fill(array, 17);
        long t1 = System.currentTimeMillis();
        assertFalse(threadCheck.findNotPrime(array));
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }

    @Test
    void test1_2() {
        ThreadCheck threadCheck = new ThreadCheck();
        threadCheck.setCountOfThreads(2);
        Arrays.fill(array, 17);
        long t1 = System.currentTimeMillis();
        assertFalse(threadCheck.findNotPrime(array));
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }

    @Test
     void test1_3() {
        ThreadCheck threadCheck = new ThreadCheck();
        threadCheck.setCountOfThreads(3);
        Arrays.fill(array, 17);
        long t1 = System.currentTimeMillis();
        assertFalse(threadCheck.findNotPrime(array));
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }

    @Test
    void test1_4() {
        ThreadCheck threadCheck = new ThreadCheck();
        threadCheck.setCountOfThreads(4);
        Arrays.fill(array, 17);
        long t1 = System.currentTimeMillis();
        assertFalse(threadCheck.findNotPrime(array));
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }
}