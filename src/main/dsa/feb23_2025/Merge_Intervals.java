package src.main.dsa.feb23_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Merge_Intervals {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{8,10},{2,6},{15,18}};
        int[][] arr2 = new int[][]{{1,4},{4,5}};
        System.out.println(Arrays.deepToString(merge(arr)));
        System.out.println(Arrays.deepToString(merge(arr2)));
    }

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] temp = list.getLast();
            if (interval[0] <= temp[1]/* && interval[0] >= temp[0]*/) {
                temp[1] = Math.max(interval[1], temp[1]);
            } else {
                list.add(interval);
            }
        }
        int[][] resp = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            resp[i] = ints;
        }
        return resp;
    }
}
