package src.main.dsa.gfg.problems;

import java.util.Arrays;

public class CoverageOfAllZerosInABinaryMatrix {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 0, 0}};
        System.out.println(findCoverage(mat));
    }

    public static int findCoverage(int[][] matrix) {
        // code here
        int count = 0;
        for (int[] row : matrix) {
            for (int number : row) {
                if (0 == number) {
                    int i = count++;
                }
            }
        }
        return count;
    }
}
