public class Lab8F {

    /**
     * This method simply swaps 2 elements in an array.
     * This is used for both insertion sort and quicksort
     *
     * @param arr array that contains the elements that need swapped
     * @param i   index of the first element
     * @param j   index of the second element
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * INSERTION SORT
     *
     * do NOT use Collections.sort that will result in a 0 for this method
     *
     * This is an insertion sort where you must sort the elements in the array
     * For an in depth explanation of insertion sort see:
     * https://www.geeksforgeeks.org/insertion-sort/
     *
     * @param arr array to be sorted
     * @return the sorted array
     */
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i -1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j -1;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    /**
     * QUICKSORT
     *
     * do NOT use Collections.sort that will result in a 0 for this method
     *
     * This is a recursive quicksort that will partition the array into 2 spots
     * if the starting index is less that the ending index and recursively call
     * quick sort on those 2 sections
     *
     * @param arr  array to be sorted
     * @param low  starting index
     * @param high ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * PARTITION
     *
     * This method sets the last element as the pivot element and
     * places is where it should go in the sorted array by placing
     * all elements smaller than the pivot to the left of the pivot
     * and all elements greater than the pivot to the right of the pivot
     *
     * @param arr  array you are finding the index of
     * @param low  starting index
     * @param high ending index
     * @return the correct index where you should partition the array
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
}