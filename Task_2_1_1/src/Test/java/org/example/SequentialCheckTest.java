package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SequentialCheckTest {
    int[] array = new int[100_000_000];


    @Test
    void testBig() {
        Arrays.fill(array, 17);
        assertFalse(SequentialCheck.checkCompositeNumbers(array));
    }

    @Test
    void test1() {
        int arr[] = {6, 8, 7, 13, 5, 9, 4};
        assertTrue(SequentialCheck.checkCompositeNumbers(arr));
    }

    @Test
    void test2() {
        int arr[] = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053};
        assertFalse(SequentialCheck.checkCompositeNumbers(arr));
    }
}