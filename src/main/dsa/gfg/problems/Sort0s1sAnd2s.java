package src.main.dsa.gfg.problems;

import java.util.Arrays;

public class Sort0s1sAnd2s {

    public static void main(String[] args) {
        int[] a1 = new int[]{0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(a1));
        sort012(a1);
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println(Arrays.toString(a2));
        sort012(a2);
        System.out.println(Arrays.toString(a2));
    }

    public static void sort012(int[] arr) {
        // code here
        int i, j, k;
        i = j = 0;
        k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[j] == 1) {
                j++;
            } else {
                swap(arr, j, k);
                k--;
            }
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
