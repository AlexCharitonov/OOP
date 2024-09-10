package org.example;

public class Heap {

    /**
     * calls function to build heap and sorts it.
     * @return array
     */
    public static int[] heapsort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            int help = array[i];
            array[i] = array[0];
            array[0] = help;
            heap_sift_down(array, i, 0);
        }
        return array;
    }

    /**
     * build heap from array.
     */
    private static void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heap_sift_down(array, array.length, i);
        }
    }

    /**
     * The function takes a vertex and its right and left child.
     * Then they are compared with each other, and if the vertex is smaller than at least one of the children,
     * then vertex switch places with the biggest child,
     * then the function starts again trying to place vertex in the most bottom place that possible
     */
    private static void heap_sift_down(int[] array, int current_length_of_array, int vertex) {
        int id_of_biggest_value_in_family = vertex;
        int id_of_left_child = 2 * vertex + 1;
        int id_of_right_child = 2 * vertex + 2;
        if (id_of_left_child < current_length_of_array &&
                array[id_of_left_child] > array[id_of_biggest_value_in_family]) {
            id_of_biggest_value_in_family = id_of_left_child;
        }
        if (id_of_right_child < current_length_of_array &&
                array[id_of_right_child] > array[id_of_biggest_value_in_family]) {
            id_of_biggest_value_in_family = id_of_right_child;
        }
        if (id_of_biggest_value_in_family != vertex) {
            int help = array[vertex];
            array[vertex] = array[id_of_biggest_value_in_family];
            array[id_of_biggest_value_in_family] = help;
            heap_sift_down(array, current_length_of_array, id_of_biggest_value_in_family);
        }
    }
}
