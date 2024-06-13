package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringV4("abba"));
    }

    /**
     * Brute force implemented as per my logic and understanding
     *
     * @param s Input String
     * @return Size Longest Substring Without Repeating Characters
     */
    public static int lengthOfLongestSubstring(String s) {
//        int max = 0;
//        for (int i = 0; i < s.length() - 1; i++) {
//            Map<String, Integer> map = new HashMap<>();
//            for (int j = i; j < s.length(); j++) {
//                String x = s.substring(i,j);
//                map.put(String.valueOf(s.charAt(j)), map.getOrDefault(String.valueOf(s.charAt(j)),0)+1);
//                if (1 <= map.get(String.valueOf(s.charAt(j)))) {
//                    max = Math.max(max, x.length());
//                }
//            }
//        }
//        return max;

        if (s.isEmpty())
            return 0;

        int size = 1;

        if (1 == s.length())
            return size;

        int left = 0;
        int right = 1;

        int count = 1;
        while (right < s.length()) {
            String x = s.substring(left, right);
            if (!x.contains(String.valueOf(s.charAt(right)))) {
                right++;
                count++;
            } else {
                count = 1;
                left++;
                right = left + 1;
            }
            size = Math.max(size, count);
        }

        return size;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        int left = 0;
        int right = 0;
        int length = 0;

        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                length = Math.max(length, right - left + 1);
                right++;
            }
        }

        return length;
    }


    public static int lengthOfLongestSubstringV3(String s) {
        int left = 0;
        int right = 0;
        int length = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            length = Math.max(length, right - left + 1);
            right++;
        }

        return length;
    }

    public static int lengthOfLongestSubstringV4(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128];

        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
