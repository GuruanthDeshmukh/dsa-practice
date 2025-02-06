package src.main.dsa.leetcode.daily_practice_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rank_Transform_of_an_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{100, 100, 100})));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] resp = new int[arr.length];
        int[] temp = Arrays.copyOf(arr, arr.length);
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            resp[i] = map.get(arr[i]) + 1;
        }
        return resp;
    }
}
