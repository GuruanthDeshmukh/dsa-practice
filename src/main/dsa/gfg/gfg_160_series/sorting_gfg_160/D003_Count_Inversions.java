package src.main.dsa.gfg.gfg_160_series.sorting_gfg_160;

import java.util.ArrayList;

public class D003_Count_Inversions {
    public static void main(String[] args) {
        System.out.println(inversionCount(new int[]{2, 4, 1, 3, 5}));
        System.out.println(inversionCount(new int[]{2, 3, 4, 5, 6}));
        System.out.println(inversionCount(new int[]{10, 10, 10}));
        System.out.println(inversionCount(new int[]{24, 18, 38, 43, 14, 40, 1, 54}));
    }

    public static int inversionCount(int[] arr) {
        // Your Code Here
        int res = 0;
        res += mergeSort(arr, 0, arr.length - 1);
        return res;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int res = 0;
        if (low >= high)
            return res;
        int mid = (low + high) / 2;
        res += mergeSort(arr, low, mid);
        res += mergeSort(arr, mid + 1, high);
        res += merge(arr, low, mid, high);
        return res;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int res = 0;
        if (low >= high)
            return res;

        int left = low, right = mid + 1, tmp_count = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                res += right - left - tmp_count;
                tmp_count++;
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        int index = 0;
        for (int i = low; i <= high; i++) {
            Integer integer = temp.get(index);
            arr[i] = integer;
            index++;
        }
        return res;
    }
}
