package org.example;

/**
 * class for heap sorting.
 */
public class Heap {

    /**
     * calls function to build heap and sorts it.
     *
     * @return array
     */
    public static int[] heapsort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            int help = array[i];
            array[i] = array[0];
            array[0] = help;
            heapSiftDown(array, i, 0);
        }
        return array;
    }

    /**
     * build heap from array.
     */
    private static void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapSiftDown(array, array.length, i);
        }
    }

    /**
     * The function takes a vertex and its right and left child.
     * Then they are compared with each other,
     * then if the vertex is smaller than at least one of the children,
     * then vertex switch places with the biggest child,
     * then the function starts again trying to place vertex in the most bottom place that possible
     */
    private static void heapSiftDown(int[] array, int currentLengthOfArray, int vertex) {
        int idOfBiggestValueInFamily = vertex;
        int idOfLeftChild = 2 * vertex + 1;
        int idOfRightChild = 2 * vertex + 2;
        if (idOfLeftChild < currentLengthOfArray
                && array[idOfLeftChild] > array[idOfBiggestValueInFamily]) {
            idOfBiggestValueInFamily = idOfLeftChild;
        }
        if (idOfRightChild < currentLengthOfArray
                && array[idOfRightChild] > array[idOfBiggestValueInFamily]) {
            idOfBiggestValueInFamily = idOfRightChild;
        }
        if (idOfBiggestValueInFamily != vertex) {
            int help = array[vertex];
            array[vertex] = array[idOfBiggestValueInFamily];
            array[idOfBiggestValueInFamily] = help;
            heapSiftDown(array, currentLengthOfArray, idOfBiggestValueInFamily);
        }
    }
}
