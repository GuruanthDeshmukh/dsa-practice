package src.main.dsa.neetcode.two_fifty.sliding_window;

import java.util.HashMap;

public class Longest_Repeating_Character_Replacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacement("AAAB", 0));
        System.out.println(characterReplacement("IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR", 0));
    }

    public static int characterReplacement(String s, int k) {
        int chars_to_be_changed = 0;
        int window_size = 0;
        int max_freq = 0;
        int index = 0;
        int startIndex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (index < s.length()) {
            Character ch = s.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            window_size++;
            max_freq = Math.max(max_freq, map.get(ch));
            chars_to_be_changed = window_size - max_freq;
            if (chars_to_be_changed > k) {
                map.put(s.charAt(startIndex), map.get(s.charAt(startIndex)) - 1);
                if (map.get(s.charAt(startIndex)) == null)
                    map.remove(s.charAt(startIndex));
                window_size--;
                startIndex++;
            }
            index++;
        }
        return window_size;
    }
}
