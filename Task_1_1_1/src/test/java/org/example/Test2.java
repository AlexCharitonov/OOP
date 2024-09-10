package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * test2.
 */
public class Test2 {
    /**
     * Test2.
     */

    @Test
    void main() {
        int[] arr = Heap.heapsort(new int[] {10892, 345, 670, 8, 0, 234, 43, 555, 123444, 999999});
        int[] trueArr = {0, 8, 43, 234, 345, 555, 670, 10892, 123444, 999999};
        for (int i = 0; i < trueArr.length; i++) {
            assertEquals(trueArr[i], arr[i]);
        }
    }
}
