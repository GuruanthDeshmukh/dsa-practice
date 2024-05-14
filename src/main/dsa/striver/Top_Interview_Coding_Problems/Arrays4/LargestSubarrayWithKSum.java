package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays4;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithKSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,-1,3,2,-2,-8,1,7,10,23};
        System.out.println(maxLen(arr, arr.length));
        System.out.println(maxLenV2(arr, arr.length));
    }

    /**
     * Brute force approach. PFB commented approaches are the once
     * that were futile attempts to solve the problem. Solved by referring
     * the brute force approach mentioned in solution section.
     *
     * @param arr Input array
     * @param n Size of array
     * @return size of maximum sub array with sum zero
     */
    public static int maxLen(int[] arr, int n) {
//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            int count = 1;
//            if (0 == arr[i])
//                count--;
//            long currentSum = arr[i];
//            for (int j = i; j < n; j++) {
//                if (0 == arr[j]) {
//                    count++;
//                    result = Math.max(count, result);
//                    continue;
//                }
//                if (j == i){
//                    continue;
//                }
//                count++;
//                currentSum += arr[j];
//                if (0 == currentSum) {
//                    result = Math.max(count, result);
//                }
//            }
//        }
//
//        if (0 == result)
//            return result;
//        return result;



//        int maxSize = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = arr[i];
//            int current_index = i+1;
//            int count = 0;
//            while (current_index < n) {
//                if (0 == sum)
//                    count++;
//
//                sum += arr[current_index];
//                if (0 == sum) {
//                    count++;
//                    maxSize = Math.max(count, maxSize);
//                }
//
//                current_index++;
//            }
//        }
//
//        return maxSize;

        int max = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int current_index = i;
            while (current_index < n) {
                sum += arr[current_index];

                if (0 == sum) {
                    max = Math.max(current_index - i + 1, max);
                }
                current_index++;
            }
        }

        return max;
    }

    /**
     * Optimal approach.
     * <a href="https://www.youtube.com/watch?v=xmguZ6GbatA">Solution Link Referred</a>
     * @param arr Input array
     * @param n Size of array
     * @return Size of maximum subarray with sum 0.
     */
    public static int maxLenV2(int[] arr, int n) {

        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (0 == sum) {
                max = Math.max(i+1, max);

            } else {
                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum,i);
                }
            }
        }

        return max;
    }
}
