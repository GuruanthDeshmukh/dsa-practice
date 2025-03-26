package src.main.dsa.neetcode.two_fifty.sliding_window;

import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringV2("abcabcbb"));
        System.out.println(lengthOfLongestSubstringV3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstringV2("bbbbb"));
        System.out.println(lengthOfLongestSubstringV3("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstringV2("pwwkew"));
        System.out.println(lengthOfLongestSubstringV3("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstringV2("dvdf"));
        System.out.println(lengthOfLongestSubstringV3("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        StringBuilder currentLongest = new StringBuilder();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (currentLongest.indexOf(String.valueOf(s.charAt(i))) == -1) {
                currentLongest.append(s.charAt(i));
                res = Math.max(currentLongest.length(), res);
            } else {
                int index = currentLongest.indexOf(String.valueOf(s.charAt(i)));
                currentLongest = new StringBuilder(currentLongest.subSequence(index + 1, currentLongest.length()));
                currentLongest.append(s.charAt(i));
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            if (set.size() > res)
                res = set.size();
        }
        return res;
    }

    public static int lengthOfLongestSubstringV3(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int res = 0;
        int[] freq = new int[128];
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            freq[ch]++;
            while (freq[ch] > 1) {
                char chi = s.charAt(i);
                freq[chi]--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
