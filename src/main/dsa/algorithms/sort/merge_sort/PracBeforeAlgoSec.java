package src.main.dsa.algorithms.sort.merge_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class PracBeforeAlgoSec {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 0, 13, 2, 8, 9, 1, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (0 == arr.length || start >= end)
            return;

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;

        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= end) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp.get(i - start);
        }

    }

}
