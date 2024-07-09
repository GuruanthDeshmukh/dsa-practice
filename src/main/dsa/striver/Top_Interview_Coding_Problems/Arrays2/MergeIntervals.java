package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println("Before Merging");
        Arrays.stream(arr).sequential().forEach(subarr -> {
            Arrays.stream(subarr).sequential().forEach(element -> {
                System.out.print(element + " ");
            });
            System.out.println();
        });
        int[][] resp = mergeOverlappingIntervals(arr);
        System.out.println("After Merging");
        Arrays.stream(resp).sequential().forEach(subarr -> {
            Arrays.stream(subarr).sequential().forEach(element -> {
                System.out.print(element + " ");
            });
            System.out.println();
        });
    }

    public static int[][] mergeOverlappingIntervals(int[][] arr) {

        if (arr.length <= 1)
            return arr;

        List<int[]> response = new ArrayList<>(arr.length);

        Arrays.sort(arr, Comparator.comparingInt(i -> i[0]));

        int[] current = arr[0];
        response.add(current);

        for (int[] interval : arr) {
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                response.add(current);
            }
        }

        return response.toArray(new int[response.size()][]);
    }
}
