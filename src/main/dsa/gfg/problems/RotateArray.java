package src.main.dsa.gfg.problems;

import java.util.Arrays;
import java.util.Collections;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        rotateArrV3(arr, 8, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArr(int[] arr, int d, int n) {
        // add your code here
        d %= n;
        int[] tmp = new int[n];
        int index = 0;

        for (int i = d; i < n; i++) {
            tmp[index] = arr[i];
            index++;
        }

        for (int i = 0; i < d; i++) {
            tmp[index] = arr[i];
            index++;
        }

        System.arraycopy(tmp, 0, arr, 0, tmp.length);

    }

    public static void rotateArrV2(int[] arr, int d, int n) {
        d %= n;
        while (d != 0) {
            int temp = arr[0];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = temp;
            d--;
        }
    }

    public static void rotateArrV3(int[] arr, int d, int n) {
        d = n - 1 - d % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, d);
        reverse(arr, d + 1, n - 1);
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
