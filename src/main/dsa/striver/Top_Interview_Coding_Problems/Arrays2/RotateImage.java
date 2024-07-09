package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays2;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        System.out.println("-------INPUT-------");
        Arrays.stream(matrix).sequential().forEach(row -> {
            Arrays.stream(row).sequential().forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
        System.out.println();
        rotate2(matrix);
        System.out.println("-------OUTPUT-------");
        Arrays.stream(matrix).sequential().forEach(row -> {
            Arrays.stream(row).sequential().forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
    }

    public static void rotate(int[][] matrix) {
        int totalSwaps = 0;
        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = 0; j <= matrix[i].length / 2; j++) {
                swap2(matrix, i, j);
                totalSwaps = printMatrix(matrix, totalSwaps);
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][matrix.length - i - 1];
        matrix[j][matrix.length - i - 1] = temp;
    }

    private static void swap2(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[matrix.length - i - 1][j];
        matrix[matrix.length - i - 1][j] = matrix[matrix.length - i - 1][matrix.length - j - 1];
        matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[i][matrix.length - j - 1];
        matrix[i][matrix.length - j - 1] = temp;
    }

    public static void rotate2(int[][] matrix) {
//        int totalSwaps = 0;
        for (int k = 0; k < (matrix.length + 1) / 2; k++) {
            for (int i = 0; i < matrix.length / 2; i++) {
                swap3(matrix, k, i);
//                totalSwaps = printMatrix(matrix, totalSwaps);
            }
        }
    }

    private static void swap3(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[matrix.length - 1 - j][i];
        matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
        matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
        matrix[j][matrix.length - 1 - i] = temp;
    }

    private static int printMatrix(int[][] matrix, int totalSwaps) {
        totalSwaps++;
        System.out.println("Current step : " + totalSwaps);
        Arrays.stream(matrix).sequential().forEach(row -> {
            Arrays.stream(row).sequential().forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
        System.out.println();
        return totalSwaps;
    }

//    public static String findDivision(int x, int y, int n) {
//        // Write your code here.
//        float result = (float) x/y;
//        String response = String.valueOf(result);
//        int charCount = response.length();
//
//        if(charCount>n)
//            return response.substring(0, n+1);
//
//        for (int i=charCount-1; i<=n; i++) {
//            response.concat(String.valueOf(0));
//        }
//
//        return response;
//    }
}
