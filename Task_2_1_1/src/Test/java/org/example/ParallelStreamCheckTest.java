package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class ParallelStreamCheckTest {
    Integer[] array = new Integer[100_000_000];

    @Test
    void testBig() {
        Arrays.fill(array, 17);
        assertFalse(ParallelStreamCheck.checkCompositeNumbers(array));
    }

    @Test
    void test1() {
        Integer arr[] = {6, 8, 7, 13, 5, 9, 4};
        assertTrue(ParallelStreamCheck.checkCompositeNumbers(arr));
    }

    @Test
    void test2() {
        Integer arr[] = {20319251, 6997901, 6997927, 6997937, 17858849, 6997967,
                6998009, 6998029, 6998039, 20165149, 6998051, 6998053};
        assertFalse(ParallelStreamCheck.checkCompositeNumbers(arr));
    }
}