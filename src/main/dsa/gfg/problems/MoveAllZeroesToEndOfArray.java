package src.main.dsa.gfg.problems;

import java.util.Arrays;

public class MoveAllZeroesToEndOfArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1 || nums.length == 0)
            return;

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
            right++;
        }
    }
}
