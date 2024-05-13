package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays4;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(twoSumV2(new int[]{2,7,11,15}, 9)[0]);
        System.out.println(twoSumV2(new int[]{2,7,11,15}, 9)[1]);
    }
    /**
    * Brute force approach
    */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j])
                    return new int[]{i,j};
            }
        }
        return new int[0];
    }

    /**
     * Optimal approach using Map to store the difference
     */
    public static int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++ ) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            else
                map.put(nums[i], i);
        }
        return new int[2];
    }
}
