package src.main.dsa.leetcode.daily_practice_problem.march;

import java.util.Arrays;

public class Apply_Operations_to_an_Array {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(applyOperationsV2(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(applyOperations(new int[]{0, 1})));
        System.out.println(Arrays.toString(applyOperations(new int[]{0, 1})));
    }

    public static int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] *= 2;
                    nums[i + 1] = 0;
                }
                res[index] = nums[i];
                index++;
            }
        }
        if (nums[nums.length - 1] != 0)
            res[index] = nums[nums.length - 1];

        return res;
    }

    public static int[] applyOperationsV2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0 && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        return nums;
    }

}
