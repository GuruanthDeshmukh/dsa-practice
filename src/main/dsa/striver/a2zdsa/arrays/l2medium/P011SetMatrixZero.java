package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.Arrays;

public class P011SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1, 2, 0, 1, 2}, {3, 0, 5, 2, 0, 6}, {1, 3, 1, 5, 1, 1}};
        System.out.println("i/p arr : " + Arrays.deepToString(arr));
        setZeroes(arr);
        System.out.println("o/p arr : " + Arrays.deepToString(arr));
    }

    public static void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int[] num : matrix) {
            if (num[0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int j = 1; j < matrix.length; j++) {
            for (int i = 1; i < matrix[j].length; i++) {
                if (matrix[j][i] == 0) {
                    matrix[0][i] = 0;
                    matrix[j][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
