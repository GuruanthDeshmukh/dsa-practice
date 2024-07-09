package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
//        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(longestConsecutiveV2(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
//        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    /**
     * Brute force approach.
     * Have 2 variables,
     * result and count. Result will be output
     * and count will be counter.
     * Sort the array, and then iterate it.
     * If current element of array is 1 lesser
     * than next element, increase the counter.
     * If they are same, we go to next iteration.
     * Default case will be where we reset counter to 1.
     * Result is maximum of current value of result and counter.
     *
     * @param nums Array of numbers
     * @return length of longest sequence
     */
    public static int longestConsecutive(int[] nums) {
        //if length is 0, longest sequence will be 0
        if (0 == nums.length) return 0;

        int result = 1;
        int count = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) count++;
            else if (nums[i] == nums[i + 1]) continue;
            else count = 1;
            result = Math.max(result, count);
        }
        return result;
    }
    /*
     Did not understand the optimal approach mentioned by Striver but may be will understand in the future.
     The above implemented approach is quite optimized as per Leetcode.
     Here below are the results :
       Runtime
           15 ms
       Beats
           95.49% of users with Java
       Memory
           56.76MB
       Beats
           80.22% of users with Java
    */

    public static int longestConsecutiveV2(int[] nums) {

        if (0 == nums.length) return 0;

        int result = 1;
        int count = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        //my understanding
        for (int num : nums) {
            if (set.contains(num - 1)) {
                count = 1;
                result = Math.max(result, count);
                continue;
            }

            while (set.contains(num)) {
                count++;
                num++;
            }

            result = Math.max(result, count);
        }

//        //striver method
//        for (int it : set) {
//            if (!set.contains(it - 1)) {
//
//                int cnt = 1;
//                int x = it;
//                while (set.contains(x + 1)) {
//                    x = x + 1;
//                    cnt = cnt + 1;
//                }
//                result = Math.max(result, cnt);
//            }
//        }

        return result;
    }
    
}
