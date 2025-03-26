package src.main.dsa.leetcode.daily_practice_problem.pre_march;

public class Maximum_Matrix_Sum {

    public static void main(String[] args) {
//        System.out.println(maxMatrixSum(new int[][]{{1,-1},{-1,1}}));
//        System.out.println(maxMatrixSum(new int[][]{{1,2,3},{-1,-2,-3},{1,2,3}}));
        System.out.println(maxMatrixSum(new int[][]{{-1, 0, -1}, {-2, 1, 3}, {3, 2, 2}}));
        System.out.println("-x-x-x-");
        System.out.println(maxMatrixSumV2(new int[][]{{-1, 0, -1}, {-2, 1, 3}, {3, 2, 2}}));
    }

    public static long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int lowestNumber = Integer.MAX_VALUE;
        int negativeCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    System.out.println("current negative number " + matrix[i][j] + " on i : " + i + " and j : " + j);
                    negativeCount++;
                    lowestNumber = Math.min(Math.abs(matrix[i][j]), lowestNumber);
                    System.out.println("lowest number : " + lowestNumber);
                }
                res += Math.abs(matrix[i][j]);
            }
        }

        return negativeCount % 2 == 0 ? res : res - 2L * lowestNumber;
    }

    public static long maxMatrixSumV2(int[][] matrix) {
        long res = 0;
        int lowestNumber = Integer.MAX_VALUE;
        int negativeCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    System.out.println("current negative number " + matrix[i][j] + " on i : " + i + " and j : " + j);
                    negativeCount++;
                    System.out.println("lowest number : " + lowestNumber);
                }
                lowestNumber = Math.min(Math.abs(matrix[i][j]), lowestNumber);
                res += Math.abs(matrix[i][j]);
            }
        }

        return negativeCount % 2 == 0 ? res : res - 2L * lowestNumber;
    }
}
