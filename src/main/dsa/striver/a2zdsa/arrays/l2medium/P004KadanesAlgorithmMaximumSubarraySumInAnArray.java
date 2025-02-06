package src.main.dsa.striver.a2zdsa.arrays.l2medium;

public class P004KadanesAlgorithmMaximumSubarraySumInAnArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }

    public static int maxSubArray(int[] nums) {
        if (1 == nums.length)
            return nums[0];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        while (index < nums.length) {
            sum += nums[index];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
                index++;
                continue;
            }
            index++;
        }
        return maxSum;
    }
}
