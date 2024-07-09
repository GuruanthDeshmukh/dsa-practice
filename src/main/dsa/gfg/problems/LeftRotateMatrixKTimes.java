package src.main.dsa.gfg.problems;

import java.util.Arrays;

public class LeftRotateMatrixKTimes {

    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE);
//        int[][] mat = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
//        for (int[] ints : mat) {
//            System.out.println(Arrays.toString(ints));
//        }
//        rotateMatrix(2, mat);
//        for (int[] ints : mat) {
//            System.out.println(Arrays.toString(ints));
//        }
    }

    static int[][] rotateMatrix(int k, int[][] mat) {
        // code here
        for (int i = 0; i < mat.length; i++) {
            int[] arr = mat[i];
            rotateArr(arr, k, arr.length);
        }
        return mat;
    }

    static void rotateArr(int[] arr, int d, int n) {
        d = n - 1 - d % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, d);
        reverse(arr, d + 1, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
