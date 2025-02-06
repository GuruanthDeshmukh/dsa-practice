package src.main.dsa.gfg.gfg_160_series.sorting_gfg_160;

import java.util.ArrayList;
import java.util.Arrays;

// revision needed
public class D005_Insert_Interval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insertIntervalV3(new int[][]{{1, 3}, {4, 5}, {6, 7}, {8, 10}}, new int[]{5, 6}).toArray()));
        System.out.println(Arrays.deepToString(insertIntervalV3(new int[][]{{1, 3}, {10, 15}, {20, 30}}, new int[]{5, 6}).toArray()));
        System.out.println(Arrays.deepToString(insertIntervalV3(new int[][]{{0, 40}}, new int[]{82, 97}).toArray()));
        System.out.println(Arrays.deepToString(insertIntervalV3(new int[][]{{0, 137}, {141, 153}, {157, 207}, {236, 240}}, new int[]{47, 75}).toArray()));
        System.out.println(Arrays.deepToString(insertIntervalV3(new int[][]{{1, 5}}, new int[]{0, 3}).toArray()));
        System.out.println(Arrays.deepToString(insertIntervalV3(new int[][]{{1, 5}}, new int[]{0, 13}).toArray()));
    }

    public static ArrayList<int[]> insertInterval(int[][] arr, int[] newInterval) {
        // Code here // Code here
        Arrays.sort(arr, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        boolean intervalAdded = false;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            if (list.isEmpty()) {
                list.add(ints);
                continue;
            }
            if (!intervalAdded) {
                intervalAdded = true;
                if (list.get(list.size() - 1)[1] >= newInterval[0]) {
                    int[] ele = list.remove(list.size() - 1);
                    list.add(new int[]{Math.min(ele[0], newInterval[0]), Math.max(ele[1], newInterval[1])});
                    i--;
                    continue;
                } else {
                    list.add(newInterval);
                }
            }
            if (list.get(list.size() - 1)[1] >= ints[0]) {
                int[] ele = list.remove(list.size() - 1);
                list.add(new int[]{Math.min(ele[0], ints[0]), Math.max(ele[1], ints[1])});
            } else {
                list.add(ints);
            }
        }
        if (!intervalAdded) {
            if (list.get(list.size() - 1)[1] >= newInterval[0]) {
                int[] ele = list.remove(list.size() - 1);
                list.add(new int[]{Math.min(ele[0], newInterval[0]), Math.max(ele[1], newInterval[1])});
            } else {
                list.add(newInterval);
            }
        }

        return list;
    }

    public static ArrayList<int[]> insertIntervalV2(int[][] arr, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int index = 0;
        int[] temp = new int[2];
        while (index < arr.length) {
            if (arr[index][0] > newInterval[0]) {
                temp[0] = newInterval[0];
                if (arr[index][1] >= newInterval[0]) {
                    temp[1] = Math.max(newInterval[1], arr[index][1]);
                } else {
                    temp[1] = newInterval[1];
                }
            }
        }
        return null;
    }

    public static ArrayList<int[]> insertIntervalV3(int[][] arr, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int index = 0;
        while (index < arr.length && arr[index][1] < newInterval[0]) {
            list.add(arr[index]);
            index++;
        }
        while (index < arr.length && arr[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(arr[index][0], newInterval[0]);
            newInterval[1] = Math.max(arr[index][1], newInterval[1]);
            index++;
        }
        list.add(newInterval);
        while (index < arr.length) {
            list.add(arr[index]);
            index++;
        }

        return list;
    }
}
