package src.main.dsa.leetcode.daily_practice_problem.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition_Array_According_to_Given_Pivot {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        System.out.println(Arrays.toString(pivotArrayV2(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
        System.out.println(Arrays.toString(pivotArray(new int[]{-3, 4, 3, 2}, 2)));
        System.out.println(Arrays.toString(pivotArrayV2(new int[]{-3, 4, 3, 2}, 2)));
        System.out.println(Arrays.toString(pivotArray(new int[]{19, 15, 12, -14, 8, -7, -11}, -7)));
        System.out.println(Arrays.toString(pivotArrayV2(new int[]{19, 15, 12, -14, 8, -7, -11}, -7)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lesserThanPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot)
                lesserThanPivot.add(num);
            else if (num > pivot)
                greaterThanPivot.add(num);
        }
        int index = 0;
        for (Integer i : lesserThanPivot) {
            nums[index] = i;
            index++;
        }
        int temp = 0;
        while (temp < Math.abs(nums.length - (lesserThanPivot.size() + greaterThanPivot.size()))) {
            nums[index] = pivot;
            index++;
            temp++;
        }
        for (Integer i : greaterThanPivot) {
            nums[index] = i;
            index++;
        }

        return nums;
    }

    public static int[] pivotArrayV2(int[] nums, int pivot) {
        int end = nums.length - 1;
        int start = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[start] = nums[i];
                start++;
            } else if (nums[i] > pivot) {
                res[end] = nums[i];
                end--;
            }
        }
        while (start <= end) {
            res[start] = pivot;
            start++;
        }
        reverse(res, start);
        return res;
    }

    private static void reverse(int[] nums, int i) {
        int temp = 0;
        while (i < nums.length - 1 - temp) {
            swap(nums, i, nums.length - 1 - temp);
            temp++;
            i++;
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
