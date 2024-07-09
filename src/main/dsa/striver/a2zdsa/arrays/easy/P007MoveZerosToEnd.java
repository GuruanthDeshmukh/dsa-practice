package src.main.dsa.striver.a2zdsa.arrays.easy;

import java.util.Arrays;

public class P007MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1 || nums.length == 0)
            return;

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (0 != nums[right]) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
