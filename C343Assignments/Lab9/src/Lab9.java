import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lab9 {

    /** RADIX SORT
     *
     * This is NOT a recursive algorithm in the normal sense
     * This is to iterate through the digits of each number
     *
     * This method simply iterates through the number of digits in the max
     * element and calls radixHelper
     *
     * @param arr array to be sorted
     */
    static void radixSort(int[] arr) {
        int max = max(arr);

        for (int place = 1; max / place > 0; place *= 10) {
            radixHelper(arr, place);
        }
    }

    /** RADIX HELPER
     *
     * Words do not do it justice. For a visualization see:
     * https://www.cs.usfca.edu/~galles/visualization/RadixSort.html
     *
     * @param arr array to be sorted
     * @param place the placement of the digit you are on
     */
    static void radixHelper(int[] arr, int place) {
        int n = arr.length;
        int[] count = new int[10];
        int[] output = new int[n];

        for (int num : arr) {
            int digit = (num / place) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    /** BUCKET SORT
     *
     * you are allowed to use Collections.Sort ONLY for sorting the individual buckets
     *
     * bucket sort is a scatter and gather sorting algorithm where you split all the
     * elements into "buckets" that correspond with which range the number lies in.
     *
     * You must first get the maximum and minimum elements and then calculate the ranges
     * the buckets will use.
     *
     * hint: (max - min) / number of buckets
     *
     * You must then disperse the elements into their corresponding buckets
     *
     * Then sort the buckets. (This is where you may use Collections.Sort or copy code
     * from the previous lab idc)
     *
     * Lastly "dump" the buckets back into the arr and you are done!
     *
     * @param arr array to be sorted
     * @param noOfBuckets the number of buckets to be used
     */
    static void bucketSort(int[] arr, int noOfBuckets){
        int min = min(arr);
        int max = max(arr);

        double range = (double) (max - min) / noOfBuckets;

        List<List<Integer>> buckets = new LinkedList<>();
        for (int i = 0; i < noOfBuckets; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int num : arr) {
            int bucketIndex = (int) ((num - min) / range);
            buckets.get(bucketIndex).add(num);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[index] = num;
                index++;
            }
        }
        
    }

    /** MAX
     * useful for bucket sort and radix sort
     *
     * iterate through the array and return the largest element
     *
     * @param arr array of integers
     * @return the maximum element of the array
     */
    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr) {
            if(num > max) {
                max = num;
            }
        }
        return max; 
    }

    /** MIN
     * useful for bucketsort
     *
     * iterate through the array and return the smallest element
     *
     * @param arr array of integers
     * @return the minimum element of the array
     */
    public static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if(num < min) {
                min = num;
            }
        }
        return min;
    }

}
