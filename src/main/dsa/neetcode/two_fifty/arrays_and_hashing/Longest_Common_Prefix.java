package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.Arrays;

public class Longest_Common_Prefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"abab", "aba", "abc"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs/*, (a,b) -> a.length() - b.length()*/);
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < strs[0].length()) {
            if (strs[0].charAt(index) == strs[strs.length - 1].charAt(index)) {
                sb.append(strs[0].charAt(index));
                index++;
            } else break;
        }
        return sb.toString();
    }
}
