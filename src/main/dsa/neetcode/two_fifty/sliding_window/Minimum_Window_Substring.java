package src.main.dsa.neetcode.two_fifty.sliding_window;

import java.util.HashMap;

public class Minimum_Window_Substring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        StringBuilder sb = new StringBuilder();
        if (s.length() < t.length())
            return sb.toString();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = s.length() - 1;
        int index = 0;
        while (left <= right) {
            if (!tMap.containsKey(s.charAt(index)) || tMap.get(s.charAt(index)) == sMap.get(s.charAt(index))) {
                index++;
                continue;
            }
            if (tMap.containsKey(s.charAt(index)) && sMap.get(s.charAt(index)) > tMap.get(s.charAt(index))) {
                left++;
                tMap.put(s.charAt(index), tMap.getOrDefault(t.charAt(index), 0) - 1);
            }
        }
        sb = new StringBuilder(s.substring(left, right + 1));
        return sb.toString();
    }

}
