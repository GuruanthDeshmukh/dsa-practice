package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        mergeOverlappingIntervals(new int[][]{});
    }

    public static int[][] mergeOverlappingIntervals(int[][] arr) {

        if (arr.length <= 1)
            return arr;

        List<int[]> response = new ArrayList<>(arr.length);

        Arrays.sort(arr, Comparator.comparingInt(i -> i[0]));

        int[] current = arr[0];
        response.add(current);

        for (int i = 0; i < arr.length; i++) {
//            if(arr[i][])
        }

        return response.toArray(new int[response.size()][]);
    }
}
