package src.main.dsa.striver.Top_Interview_Coding_Problems.DynamicProgramming;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "cde";
        NumberFormat formatter = new DecimalFormat("#0.00000");

        long time1 = System.nanoTime();
        System.out.println(longestCommonSubsequence(s, t));
        long duration1 = System.nanoTime() - time1;
        System.out.println("Time for method 1 : " + (formatter.format((time1 - duration1) / 1000d)));


        long time2 = System.nanoTime();
        System.out.println(longestCommonSubsequenceV2(s, t));
        long duration2 = System.nanoTime() - time2;
        System.out.println("Time for method 2 : " + (formatter.format((time2 - duration2) / 1000d)));


        long time3 = System.nanoTime();
        System.out.println(longestCommonSubsequenceV3(s, t));
        long duration3 = System.nanoTime() - time3;
        System.out.println("Time for method 3 : " + (formatter.format((time3 - duration3) / 1000d)));

    }

    private static int longestCommonSubsequence(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Character character : map1.keySet()) {
            int countInString2 = map2.getOrDefault(character, 0);
            if (countInString2 > 0) {
                map2.put(character, map2.get(character) - 1);
                count += 1;
            }
        }

        return count;
    }

    public static int longestCommonSubsequenceV2(String s, String t) {
        return recuursiveCall(s, s.length() - 1, t, t.length() - 1);
    }

    public static int recuursiveCall(String s1, int index1, String s2, int index2) {
        if (0 > index1 || 0 > index2)
            return 0;

        if (s1.charAt(index1) == s2.charAt(index2))
            return 1 + recuursiveCall(s1, index1 - 1, s2, index2 - 1);

        return Math.max(recuursiveCall(s1, index1 - 1, s2, index2),
                recuursiveCall(s1, index1, s2, index2 - 1));
    }

    public static int longestCommonSubsequenceV3(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return dpCall(s, n, t, m, dp);
    }

    public static int dpCall(String s1, int index1, String s2, int index2, int[][] dp) {
        if (0 == index1 || 0 == index2)
            return 0;

        if (-1 != dp[index1][index2])
            return dp[index1][index2];

        if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
            dp[index1][index2] = 1 + dpCall(s1, index1 - 1, s2, index2 - 1, dp);
            return dp[index1][index2];
        }

        dp[index1][index2] = Math.max(dpCall(s1, index1 - 1, s2, index2, dp),
                dpCall(s1, index1, s2, index2 - 1, dp));

        return dp[index1][index2];
    }

}
