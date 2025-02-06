package src.main.dsa.leetcode.daily_practice_problem;

public class Minimum_Size_Subarray_Sum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int i, j, sum;
        i = j = sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (sum >= target) {
                res = Math.min(res, j - i + 1);
                while (sum >= target) {
                    sum -= nums[i];
                    i++;
                    if (sum >= target) {
                        res = Math.min(res, j - i + 1);
                    }
                }
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
