package src.main.dsa.gfg.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CountNumberOfSubstringsWithExactlyKDistinctCharacters {

    public static void main(String[] args) {
//        System.out.println(countDistinctSubstringWithKDistinctChars("abc",2));
//        System.out.println(countDistinctSubstringWithKDistinctChars("aba",2));
//        System.out.println(countDistinctSubstringWithKDistinctChars("aa",1));
//        System.out.println(countDistinctSubstringWithKDistinctChars("abaaca",1));
        System.out.println(countDistinctSubstringWithKDistinctChars("cdebecb", 4));
        // cdeb, cdebe, cdebc, cdebcb
        // debec, debecb
    }

    public static int countDistinctSubstringWithKDistinctChars(String s, int k) {
        return countDistinctSubstringWithAtleastKDistinctChars(s, k) - countDistinctSubstringWithAtleastKDistinctChars(s, k - 1);
    }

    public static int countDistinctSubstringWithAtleastKDistinctChars(String s, int k) {
        int res = 0;
        int i, j;
        i = j = 0;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (i < s.length() && map.getOrDefault(s.charAt(i), 0) == 0)
                    map.remove(s.charAt(i));
                i++;
            }
            res += j - i + 1;
            j++;
        }
        return res;
    }
}
