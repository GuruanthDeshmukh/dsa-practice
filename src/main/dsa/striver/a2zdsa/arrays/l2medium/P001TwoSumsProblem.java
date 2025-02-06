package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P001TwoSumsProblem {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] resp = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                resp[0] = map.get(nums[i]);
                resp[1] = i;
                return resp;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return resp;
    }
}
