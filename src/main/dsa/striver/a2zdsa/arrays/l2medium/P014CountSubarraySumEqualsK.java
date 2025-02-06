package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.HashMap;
import java.util.Map;

public class P014CountSubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{0, 0, 0}, 0));
        System.out.println(subarraySumV2(new int[]{0, 0, 0}, 0));
        System.out.println("-x-x-");
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySumV2(new int[]{1, 1, 1}, 2));
        System.out.println("-x-x-");
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySumV2(new int[]{1, 2, 3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            prefixSum += num;
            if (prefixSum == k) {
                count++;
            }
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static int subarraySumV2(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (sum == k)
                res++;
            if (map.containsKey(sum - k))
                res++;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
