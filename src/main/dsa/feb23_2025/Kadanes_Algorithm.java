package src.main.dsa.feb23_2025;

public class Kadanes_Algorithm {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{-1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-1,5,4,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
