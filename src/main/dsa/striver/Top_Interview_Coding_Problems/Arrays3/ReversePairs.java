package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReversePairs {

    public static void main(String[] args) {
//        System.out.println(reversePairsV2(new int[]{1,3,2,3,1}));
        Map<String, String> statusMap = new HashMap<>(3);
        System.out.println(statusMap.get(12));
    }

    /**
     * Brute force
     *
     * @param arr Input array
     * @return count of reverse pairs (pairs such that number 1 > 2 * number 2)
     */
    public static int reversePairsV1(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2L * arr[j])
                    count++;
            }
        }
        return count;
    }

    public static int reversePairsV2(int[] arr) {

        if (0 == arr.length)
            return 0;

        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int start, int end) {
        if (0 == arr.length || start >= end)
            return 0;

        int mid = (start + end) / 2;
        int result = 0;

        result += mergeSort(arr, start, mid);
        result += mergeSort(arr, mid + 1, end);

        result += countPairs(arr, start, mid, end);

        result += merge(arr, start, mid, end);

        return result;
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;

        int result = 0;

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

        return result;
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

}
