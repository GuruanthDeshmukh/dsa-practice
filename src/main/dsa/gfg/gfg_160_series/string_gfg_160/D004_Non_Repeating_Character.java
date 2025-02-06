package src.main.dsa.gfg.gfg_160_series.string_gfg_160;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class D004_Non_Repeating_Character {
    public static void main(String[] args) {
        System.out.println(nonRepeatingChar("geeksforgeeks"));
        System.out.println(nonRepeatingCharV2("geeksforgeeks"));
    }

    public static char nonRepeatingChar(String s) {
        // Your code here
        char ch = '$';
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return ch;
    }

    // another approach
    public static char nonRepeatingCharV2(String s) {
        // Your code here
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (arr[index] == -1) {
                arr[index] = i;
            } else {
                arr[index] = -2;
            }
        }
        for (int i : arr) {
            if (i != -1 && i != -2)
                return s.charAt(i);
        }
        return '$';
    }
}
