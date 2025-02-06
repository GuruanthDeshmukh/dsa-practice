package src.main.dsa.leetcode.daily_practice_problem;

import java.util.Arrays;
import java.util.HashSet;

public class Extra_Characters_in_a_String {

    public static void main(String[] args) {
        System.out.println(minExtraCharV1("dwmodizxvvbosxxw",
                new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"}));
    }

    public static int minExtraCharV1(String s, String[] dictionary) {
        StringBuilder sb = new StringBuilder(s);
        for (String element : dictionary) {
            if (s.contains(element)) {
                int size = sb.indexOf(element);
                String head = sb.substring(0, Math.max(size, 0));
                String tail = sb.substring(size + element.length(), sb.length());
                sb = new StringBuilder(head.concat(tail));
            }
        }
        return sb.length();
    }

    public static int minExtraCharV2(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        int localMinCount = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {

        }
        return localMinCount;
    }
}
