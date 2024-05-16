package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays4;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubarraysWithGivenXorK {

    public static void main(String[] args) {
        System.out.println(solveV2(new int[]{4, 2, 2, 6, 4}, 6));
    }

    /**
     * Brute force approach
     *
     * @param A Array of numbers
     * @param B Target
     * @return Number of sub-arrays where XOR of elements in B.
     */
    public static int solve(int[] A, int B) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            long xor = 0;
            for (int j = i; j < A.length; j++) {
                xor ^= A[j];
                if (B == xor) {
                    count++;
                }
            }
        }
        int temp = 0;
        System.out.println();
        for (int i = 0; i < A.length; i++) {
            temp ^= A[i];
            System.out.println(" n : " + i + " value : " + temp);
        }

        return count;
    }

    /**
     * Optimal approach
     * <a href = https://www.youtube.com/watch?v=eZr-6p0B7ME> Solution Video
     *
     * @param A Input array
     * @param B Target
     * @return count of subarrays with XOR equal to B
     */
    public static int solveV2(int[] A, int B) {
        int count = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j : A) {
            xor ^= j;
            int x = B ^ xor;
            if (map.containsKey(x))
                count += map.get(x);

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}