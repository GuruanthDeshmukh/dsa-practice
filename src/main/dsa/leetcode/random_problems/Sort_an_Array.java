package src.main.dsa.leetcode.random_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort_an_Array {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 1, 2, 0, 0};
        int[] arr1 = new int[]{5, 2, 3, 1};
        int[] arr2 = new int[]{-74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10, 50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57, -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77, -39};
        long time = System.currentTimeMillis();
        sortArray(arr);
        long time1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(time1 - time);
        sortArray(arr1);
        long time2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr1));
        System.out.println(time2 - time1);
        sortArray(arr2);
        long time3 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr2));
        System.out.println(time3 - time2);
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 5,1,1,2,0,0
    // 1,5,1,2,0,0
    // 1,1,5,2,0,0
    // 1,1,2,5,0,0
    // low = 0, high = 6, mid = 3
    // low = 0, high = 3, mid = 1
    // low = 0, high = 1, mid = 0
    // low = 2, high = 3, mid = 2
    // low = 2, high = 3, mid = 2

    private static void mergeSort(int[] nums, int low, int high) {
        if (0 == nums.length || low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);

    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>(high - low + 1);
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        int x = 0;
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(x);
            x++;
        }
    }
}
