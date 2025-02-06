package src.main.dsa.neetcode.layer_1.Arrays_And_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagramV2("anagram","nagaram"));
        System.out.println(isAnagramV3("anagram","nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer value = characterIntegerEntry.getValue();
            if (value != 0)
                return false;
        }
        return true;
    }

    public static boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.getOrDefault(t.charAt(i),0) == 0)
                return false;
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        }
        return true;
    }

    public static boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] arr = new int[26];
        Arrays.fill(arr,0);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a'] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            if (arr[t.charAt(i)-'a'] <= 0)
                return false;
            arr[t.charAt(i)-'a'] -= 1;
        }

        return true;
    }

}
