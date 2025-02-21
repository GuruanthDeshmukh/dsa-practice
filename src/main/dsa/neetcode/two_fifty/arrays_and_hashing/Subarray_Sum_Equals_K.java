package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Subarray_Sum_Equals_K {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));   // 2
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));   // 2
        System.out.println(subarraySum(new int[]{1}, 1));       // 1
        System.out.println(subarraySum(new int[]{1}, 0));       // 0
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 0)); // 1
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));  // 3
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, 1);
        int i = 1;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            i++;
        }
        return res;
    }
}
