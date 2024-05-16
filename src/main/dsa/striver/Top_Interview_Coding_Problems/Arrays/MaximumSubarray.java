package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5}));
    }

    /**
     * Kadane's Algorithm for finding maximum sum of sub-array
     * <a href="https://www.youtube.com/watch?v=AHZpyENo7k4">Solution Video</a>
     *
     * @param arr Input array
     * @return Desired sum
     */
    public static int maxSubArray(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            sum += num;
            max = Math.max(max, sum);
            if (0 > sum) {
                sum = 0;
            }
        }

        return max;
    }
}
