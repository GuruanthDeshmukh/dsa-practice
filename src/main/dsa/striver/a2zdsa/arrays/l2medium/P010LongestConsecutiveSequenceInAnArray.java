package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P010LongestConsecutiveSequenceInAnArray {
    public static void main(String[] args) {
        System.out.println(longestConsecutiveV2(new int[]{100, 200, 1, 3, 2, 4}));
    }

    public static int longestConsecutive(int[] nums) {
        int len = 1;
        int maxLen = 1;
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return maxLen;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 1;
            }
        }
        return maxLen;
    }

    public static int longestConsecutiveV2(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int temp = num;
                int tempLen = 0;
                while (set.contains(temp)) {
                    tempLen++;
                    temp++;
                }
                maxLen = Math.max(maxLen, tempLen);
            }
        }
        return maxLen;
    }

}
