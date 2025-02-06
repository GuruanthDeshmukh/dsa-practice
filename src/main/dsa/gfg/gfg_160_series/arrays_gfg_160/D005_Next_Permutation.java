package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

import java.util.Arrays;

public class D005_Next_Permutation {

    public static void main(String[] args) {
        int[] a1 = new int[]{2, 4, 1, 7, 5, 0};
        System.out.println(Arrays.toString(a1));
        nextPermutation(a1);
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{3, 2, 1};
        System.out.println(Arrays.toString(a2));
        nextPermutation(a2);
        System.out.println(Arrays.toString(a2));
        int[] a3 = new int[]{3, 4, 2, 5, 1};
        System.out.println(Arrays.toString(a3));
        nextPermutation(a3);
        System.out.println(Arrays.toString(a3));
    }

    public static void nextPermutation(int[] arr) {
        // code here
        int dec_index = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                dec_index = i - 1;
                break;
            }
        }
        if (dec_index == -1) {
            reverse(arr, 0, arr.length - 1);
            return;
        }

        swapDecIndex(arr, dec_index);
        sortArrayAfterDecIndex(arr, dec_index);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static void swapDecIndex(int[] arr, int index) {
        int i = arr.length - 1;
        int index_of_next_greater_number = -1;
        int next_greater_numer = Integer.MAX_VALUE;
        while (index != i) {
            if (arr[i] > arr[index]) {
                if (arr[i] < next_greater_numer) {
                    next_greater_numer = arr[i];
                    index_of_next_greater_number = i;
                }
            }
            i--;
        }
        swap(arr, index, index_of_next_greater_number);
    }

    private static void sortArrayAfterDecIndex(int[] arr, int decIndex) {
        reverse(arr, decIndex + 1, arr.length - 1);
    }
}
