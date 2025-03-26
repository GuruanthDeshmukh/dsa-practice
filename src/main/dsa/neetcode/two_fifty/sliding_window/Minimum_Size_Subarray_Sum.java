package src.main.dsa.neetcode.two_fifty.sliding_window;

public class Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target && left <= right) {
                sum -= nums[left];
                len = Math.min(len, right - left + 1);
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
