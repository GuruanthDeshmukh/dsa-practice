package src.main.dsa.leetcode.daily_practice_problem.pre_march;

public class Longest_Palindromic_Substring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    res = s.substring(l, r + 1);
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    res = s.substring(l, r + 1);
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }

        }
        return res;
    }
}
