package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5}));
    }

    /**
     * Kadane's Algorithm for finding maximum sum of sub-array
     * <a href="https://www.youtube.com/watch?v=AHZpyENo7k4">Solution Video</a>
     * @algorithm We declare 2 variables, sum which stores sum for subarray and max which will store the maximum sum
     *      encountered so far. Sum will be initially 0, and max will be the minimum value possible.
     *      We start to iterate the array and while iterating, the sum will be sum + the current element. Max will be
     *      updated to the maximum value of sum and max.
     *      If the sum is less than 0, we will reset the sum to 0 during the iteration.
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
