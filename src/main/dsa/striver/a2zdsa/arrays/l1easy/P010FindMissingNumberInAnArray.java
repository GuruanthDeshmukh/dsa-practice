package src.main.dsa.striver.a2zdsa.arrays.l1easy;

import java.util.Arrays;

public class P010FindMissingNumberInAnArray {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumberOptimalV1(new int[]{0, 1}));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }

        return nums.length;
    }

    public static int missingNumberOptimalV1(int[] nums) {

        int s1 = (nums.length * (nums.length + 1) / 2);

        for (int num : nums) {
            s1 -= num;
        }

        return s1;
    }
}
