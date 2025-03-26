package src.main.dsa.leetcode.daily_practice_problem.pre_march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Find_Champion_II {

    public static void main(String[] args) {

    }

    public static int findChampion(int n, int[][] edges) {
        int res = -1;
        HashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int[] edge : edges) {
            List<Integer> victorOver = map.getOrDefault(edge[0], new ArrayList<>());
            victorOver.add(edge[1]);
            map.put(edge[0], map.getOrDefault(edge[0], victorOver));
        }
        return res;
    }
}
