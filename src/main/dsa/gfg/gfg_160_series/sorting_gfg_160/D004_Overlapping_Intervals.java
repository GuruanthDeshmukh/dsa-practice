package src.main.dsa.gfg.gfg_160_series.sorting_gfg_160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D004_Overlapping_Intervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeOverlap(new int[][]{{2, 4}, {6, 8}, {1, 3}, {9, 11}}).toArray()));
        System.out.println(Arrays.deepToString(mergeOverlap(new int[][]{{6, 8}, {1, 9}, {2, 4}, {4, 7}}).toArray()));
        System.out.println(Arrays.deepToString(mergeOverlap(new int[][]{{1, 2}, {2, 10}, {4, 8}, {6, 11}}).toArray()));
    }

    public static List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        Arrays.sort(arr, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        List<int[]> list = new ArrayList<>();
        for (int[] ints : arr) {
            if (list.isEmpty()) {
                list.add(ints);
                continue;
            }
            if (list.get(list.size() - 1)[1] >= ints[0]) {
                int[] ele = list.remove(list.size() - 1);
                list.add(new int[]{Math.min(ele[0], ints[0]), Math.max(ele[1], ints[1])});
            } else {
                list.add(ints);
            }
        }
        return list;
    }
}
