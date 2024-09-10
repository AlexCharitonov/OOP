package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * tests for class Heap.
 */
public class Test1 {
    /**
     * Test1.
     */

    @Test
    void main() {
        int[] arr = Heap.heapsort(new int[] {5, 4, 3, 2, 1});
        int[] trueArr = {1, 2, 3, 4, 5};
        for (int i = 0; i < trueArr.length; i++) {
            assertEquals(trueArr[i], arr[i]);
        }
    }

    @Test
    void main1() {
        int[] arr = Heap.heapsort(new int[]
            {10892, 345, 670, 8, 0, 234, 43, 555, 123444, 999999});
        int[] trueArr = {0, 8, 43, 234, 345, 555, 670, 10892, 123444, 999999};
        for (int i = 0; i < trueArr.length; i++) {
            assertEquals(trueArr[i], arr[i]);
        }
    }
}
