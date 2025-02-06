package src.main.dsa.leetcode.daily_practice_problem;

import java.util.HashMap;
import java.util.Map;

public class Make_Sum_Divisible_By_P {
    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{3, 1, 4, 2}, 6));
        System.out.println(minSubarray(new int[]{6, 3, 5, 2}, 9));
        System.out.println(minSubarray(new int[]{1, 2, 3}, 3));
    }

    public static int minSubarray(int[] nums, int p) {
        int reminder = 0;
        for (int num : nums) {
            reminder = (reminder + num) % p;
        }
        if (reminder == 0)
            return reminder;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int size = Integer.MAX_VALUE;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            int diff = (prefixSum - reminder + p) % p;
            if (map.containsKey(diff))
                size = Math.min(size, i - map.get(diff));
            map.put(diff, i);
        }
        return (size == Integer.MAX_VALUE) ? -1 : size;
    }
}
