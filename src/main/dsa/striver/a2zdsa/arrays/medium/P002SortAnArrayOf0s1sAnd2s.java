package src.main.dsa.striver.a2zdsa.arrays.medium;

import java.util.Arrays;

public class P002SortAnArrayOf0s1sAnd2s {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        int[] nums2 = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        sortColorsOptimized(nums2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }

    public static void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;

        for (int num : nums) {
            if (0 == num)
                zeroCount++;
            else if (1 == num)
                oneCount++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount != 0) {
                nums[i] = 0;
                zeroCount--;
            } else if (oneCount != 0) {
                nums[i] = 1;
                oneCount--;
            } else {
                nums[i] = 2;
            }
        }

    }

    public static void sortColorsOptimized(int[] nums) {
        int i, j, k;
        i = j = 0;
        k = nums.length - 1;

        while (j < k) {
            if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 0) {
                swap(nums, j, i);
                i++;
                j++;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
