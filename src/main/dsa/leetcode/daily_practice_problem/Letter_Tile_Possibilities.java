package src.main.dsa.leetcode.daily_practice_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Letter_Tile_Possibilities {

    static long[] factorials;

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("V"));
    }

    public static int numTilePossibilities(String tiles) {
        factorials = new long[tiles.length()];
        factorials[0] = 1;
        factorials[1] = 1;
        Arrays.fill(factorials, 0);
        long num = 1;
        long din = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < tiles.length(); j++) {
            num *= (j + 1);
            map.put(tiles.charAt(j), map.getOrDefault(tiles.charAt(j), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            din *= factorial(entry.getValue());
        }

        return (int) (num / din);
    }

    private static long factorial(Integer value) {
        long res = 1L;
        if (value == 1 || value == 0)
            return res;

        if (factorials[value] != 0)
            return factorials[value];

        res += res * factorial(value - 1);
        factorials[value] = res;

        return res;
    }
}
