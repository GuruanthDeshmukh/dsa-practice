package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays;

import java.util.Arrays;

public class SortAnArrayOf0s1s2s {

    public static void main(String[] args) {
        int[] s = new int[]{2, 0, 2, 1, 1, 0};
        Arrays.stream(s).sequential().forEach(element -> System.out.print(element + " "));
        System.out.println();
        System.out.println("-x-x-x-");
        solve(s);
        Arrays.stream(s).sequential().forEach(element -> System.out.print(element + " "));
    }

    /**
     * Sorting an array of 0, 1 and 2.
     * This is also known as Dutch flag algorithm
     * <a href="https://www.youtube.com/watch?v=tp8JIuCXBaU">Solution Video</a>
     *
     * @param args Array 0, 1 and 2
     */
    public static void solve(int[] args) {
        int i = 0, j = 0, k = args.length - 1;

        while (j <= k) {
            if (args[j] == 0) {
                swap(args, i, j);
                i++;
                j++;
            } else if (args[j] == 1) {
                j++;
            } else {
                swap(args, j, k);
                k--;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
