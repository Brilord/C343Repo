import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lab8FTest {

    @Test
    void swap() {
        int[] arr = {1, 2, 3};
        Lab8F.swap(arr, 0, 2);
        assertArrayEquals(new int[]{3, 2, 1}, arr);
    }

    @Test
    void insertionSort() {
        int[] arr = {5, 2, 1, 6, 8, 3};
        int[] expected = {1, 2, 3, 5, 6, 8};
        Lab8F.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void quickSort() {
        int[] arr = {5, 2, 1, 6, 8, 3};
        int[] expected = {1, 2, 3, 5, 6, 8};
        Lab8F.quickSort(arr, 0, arr.length-1);
        assertArrayEquals(expected, arr);
    }

    @Test
    void partition() {
        int[] arr = {5, 2, 1, 6, 8, 3};
        int pivotIndex = Lab8F.partition(arr, 0, arr.length-1);
        assertTrue(pivotIndex >= 0 && pivotIndex < arr.length);
        assertTrue(Arrays.stream(arr, 0, pivotIndex).allMatch(i -> i < arr[pivotIndex]));
        assertTrue(Arrays.stream(arr, pivotIndex+1, arr.length).allMatch(i -> i >= arr[pivotIndex]));
    }
}