package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5}));
    }

    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (0 > sum) {
                sum = 0;
            }
        }

        return max;
    }
}
