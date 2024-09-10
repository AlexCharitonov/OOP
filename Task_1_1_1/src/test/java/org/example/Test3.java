package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Test3 {
    /**
     * Test3.
     */

    @Test
    void main() {
        int[] arr = {-100, -1324, -600, -300, 0, 100, 1324, 600, 300, 0, 700, -700};
        Heap.heapsort(arr);
        int[] trueArr = {-1324, -700, -600, -300, -100, 0, 0, 100, 300, 600, 700, 1324};
        for (int i = 0; i < trueArr.length; i++) {
            assertEquals(trueArr[i], arr[i]);
        }
    }
}
