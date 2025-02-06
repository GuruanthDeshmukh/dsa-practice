package src.main.dsa.gfg.gfg_160_series.sorting_gfg_160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D006_Non_Overlapping_Intervals {

    public static void main(String[] args) {
        System.out.println(minRemovalV2(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }

    public static int minRemoval(int[][] intervals) {
        // code here
        Arrays.sort(intervals, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        List<int[]> list = new ArrayList<>();
        for (int[] ints : intervals) {
            if (list.isEmpty()) {
                list.add(ints);
                continue;
            }
            if (list.get(list.size() - 1)[1] > ints[0]) {
                int[] ele = list.remove(list.size() - 1);
                list.add(new int[]{Math.min(ele[0], ints[0]), Math.min(ele[1], ints[1])});
            } else {
                list.add(ints);
            }
        }
        return intervals.length - list.size();
    }

    public static int minRemovalV2(int[][] intervals) {
        int cnt = 0;

        // Sort by minimum starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            // If the current starting point is less than
            // the previous interval's ending point
            // (ie. there is an overlap)
            if (intervals[i][0] < end) {

                // Increase cnt and remove the interval
                // with the higher ending point
                cnt++;
                end = Math.min(intervals[i][1], end);
            }

            // Incase of no overlapping, this interval is
            // not removed and 'end' will be updated
            else
                end = intervals[i][1];
        }

        return cnt;
    }
}
