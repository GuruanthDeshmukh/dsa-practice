package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.HashSet;

public class Longest_Consecutive_Sequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (Integer element : set) {
            int count = 1;
            if (!set.contains(element - 1)) {
                while (set.contains(element + 1)) {
                    count++;
                    res = Math.max(res, count);
                    element = element + 1;
                }
            }
        }
        return res;
    }
}

