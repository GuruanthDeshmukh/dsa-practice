package src.main.dsa.leetcode.daily_practice_problem;

import java.util.HashMap;
import java.util.Map;

public class String_Compression_III {

    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }

    public static String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            while (value > 0) {
                int temp = value % 9;
                sb.append(temp).append(key);
                value /= 9;
            }
        }
        return sb.toString();
    }
}
