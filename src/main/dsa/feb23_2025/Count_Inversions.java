package src.main.dsa.feb23_2025;

import java.util.ArrayList;
import java.util.List;

public class Count_Inversions {

    public static void main(String[] args) {
        System.out.println(getInversions(new long[]{3, 2, 1}, 3));
    }

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long res = mergeSort(arr, 0, arr.length - 1);
        return res;
    }

    private static long mergeSort(long[] arr, int start, int end) {
        if (start >= end)
            return 0;

        int mid = (start + end) / 2;
        long res = 0;
        res += mergeSort(arr, start, mid);
        res += mergeSort(arr, mid + 1, end);
        res += merge(arr, start, mid, end);
        return res;
    }

    private static long merge(long[] arr, int start, int mid, int end) {
        List<Long> temp = new ArrayList<>();
        long resp = 0;
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                resp += mid - left + 1;
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

        int k = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = temp.get(k);
            k++;
        }
        return resp;

    }

}
