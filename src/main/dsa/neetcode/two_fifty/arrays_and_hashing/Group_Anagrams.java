package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagramsV2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
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

    public static List<List<String>> groupAnagramsV2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Integer[] ch = new Integer[26];
            Arrays.fill(ch, 0);
            for (int i = 0; i < str.length(); i++) {
                ch[str.charAt(i) - 'a'] += 1;
            }
            String s = getStringFromArray(ch);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(s, temp);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String getStringFromArray(Integer[] arr) {
        StringBuilder sb = new StringBuilder();
        char ch = 'a';
        for (Integer i : arr) {
            sb.append(ch).append(i);
            ch++;
        }
        return sb.toString();
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
