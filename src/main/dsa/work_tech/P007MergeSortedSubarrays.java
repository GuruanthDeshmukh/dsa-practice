package src.main.dsa.work_tech;

import java.util.Arrays;

public class P007MergeSortedSubarrays {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11, 0, 4, 6, 8};
        System.out.println(Arrays.toString(arr));
        merge(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    static void merge(int[] arr, int endIndex) {
        // add your logic here
        int[] arr1 = new int[endIndex + 1];
        int[] arr2 = new int[arr.length - endIndex - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i <= endIndex)
                arr1[i] = arr[i];
            else
                arr2[i - endIndex - 1] = arr[i];
        }
        int[] sortedArray = P006MergeTwoSortedArrays.mergeSortedArrays(arr1, arr2);
        System.arraycopy(sortedArray, 0, arr, 0, sortedArray.length);
    }

}
