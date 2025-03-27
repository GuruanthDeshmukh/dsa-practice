package src.main.dsa.interview;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s1 = "earth";
        String s2 = "heart";
        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map1.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();

            if (!map2.containsKey(key)  || map2.getOrDefault(key,-1).equals(value))
                return false;

        }

        return true;
    }


}
