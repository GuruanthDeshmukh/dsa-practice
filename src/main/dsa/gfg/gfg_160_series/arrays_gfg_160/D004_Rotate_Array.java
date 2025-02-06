package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

import java.util.Arrays;

public class D004_Rotate_Array {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a1));
        rotateArr(a1, 2);
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{1, 2};
        System.out.println(Arrays.toString(a2));
        rotateArr(a2, 2);
        System.out.println(Arrays.toString(a2));
        int[] a3 = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        System.out.println(Arrays.toString(a3));
        rotateArr(a3, 3);
        System.out.println(Arrays.toString(a3));
    }

    public static void rotateArr(int[] arr, int d) {
        // add your code here
        d = d % arr.length;
        if (d == 0)
            return;

        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
