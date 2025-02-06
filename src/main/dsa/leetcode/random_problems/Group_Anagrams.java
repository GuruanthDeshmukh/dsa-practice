package src.main.dsa.leetcode.random_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resp = new ArrayList<>();
        for (String str : strs) {
            if (resp.isEmpty()) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                resp.add(temp);
                continue;
            }
            int index = getAnagramicIndex(resp, str);
            if (index != -1) {
                List<String> strings = resp.get(index);
                resp.remove(strings);
                strings.add(str);
                resp.add(strings);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                resp.add(list);
            }
        }
        return resp;
    }

    private static int getAnagramicIndex(List<List<String>> resp, String str) {
        int index = -1;
        for (int i = 0; i < resp.size(); i++) {
            String string = resp.get(i).get(0);
            if (isAnagram(str, string)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            map1.put(s2.charAt(i), map1.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for (Map.Entry<Character, Integer> stringIntegerEntry : map1.entrySet()) {
            Integer value = stringIntegerEntry.getValue();
            if (value != 0)
                return false;
        }

        return true;
    }
}
