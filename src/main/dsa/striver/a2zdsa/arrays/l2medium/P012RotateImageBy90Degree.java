package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.Arrays;

public class P012RotateImageBy90Degree {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println("i/p arr : " + Arrays.deepToString(arr));
        rotate(arr);
        System.out.println("o/p arr : " + Arrays.deepToString(arr));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int x = n - 1;
        for (int j = 0; j < (n + 1) / 2; j++) {
            for (int i = 0; i < n / 2; i++) {
                int temp = matrix[i][x - j];
                matrix[i][x - j] = matrix[j][i];
                matrix[j][i] = matrix[x - i][j];
                matrix[x - i][j] = matrix[x - j][x - i];
                matrix[x - j][x - i] = temp;
            }
        }
    }
}
