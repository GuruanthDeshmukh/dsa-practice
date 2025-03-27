package src.main.dsa.feb23_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert_Interval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resp = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[0];
            if (temp[1] < newInterval[0]) {
                resp.add(temp);
            } else if (temp [1] >= newInterval[0]) {
                int[] arr = new int[] {Math.min(temp[0], newInterval[0]), Math.max(temp[1],newInterval[1])};
                resp.add(arr);
                j = i+1;
                break;
            }
        }
        for (int i = j; i < intervals.length; i++) {
            resp.add(intervals[i]);
        }
        int[][] arr = new int[resp.size()][2];
        for (int i = 0; i < resp.size(); i++) {
            int[] ints = resp.get(i);
            arr[i] = ints;
        }
        return arr;
    }
}
