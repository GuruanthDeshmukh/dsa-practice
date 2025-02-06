package src.main.dsa.striver.a2zdsa.arrays.l1easy;

import java.util.Arrays;

public class P002SecondLargestElementInAnArrayWithoutSorting {

    public static void main(String[] args) {
        int[] arr = new int[]{1000, 1000, 1000, 1000};
        System.out.println(print2largest(arr, 0));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int print2largest(int[] arr, int n) {
        // code here
        int larger = -1;
        if (2 > arr.length)
            return larger;

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > larger && arr[i] != largest) {
                if (arr[i] > largest) {
                    larger = largest;
                    largest = arr[i];
                    continue;
                }
                larger = arr[i];
            }
        }
        return larger;
    }
}
