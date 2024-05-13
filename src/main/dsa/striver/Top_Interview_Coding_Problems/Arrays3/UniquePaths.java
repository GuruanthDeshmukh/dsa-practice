package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays3;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(51,9));
        System.out.println(uniquePathsV2(51,9));
    }
    /**
    * Brute force approach
    */
    public static int uniquePaths(int m, int n) {
        int count = 0;
        if (m == 1 || n == 1)
            return 1;
        count += uniquePaths(m-1,n) + uniquePaths(m,n-1);
        return count;
    }


    /**
    * Optimal approach
    * Video referred : https://www.youtube.com/watch?v=IlEsdxuD4lY
    */
    public static int uniquePathsV2(int m, int n) {
        //if number of rows or column is 1, then there will only be 1 way to reach target.
        if (m == 1 || n == 1)
            return Math.max(m,n);
        //declaring an array of m x n  size.
        int[][] matrix = new int[m][n];

        //filling last row and column to be 1
        for (int i = 0; i < m; i++) {
            matrix[i][n-1] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[m-1][i] = 1;
        }

        // traversing and caching the total numbers of path for each cell in matrix.
        for (int i = m-2; i >= 0 ; i--) {
            for (int j = n-2; j >= 0 ; j--) {
                matrix[i][j] = matrix[i][j+1] + matrix[i+1][j];
            }
        }

        // total number of ways is going to be sum of 1st element in 1st row and 1st column.
        return matrix[0][1] + matrix[1][0];
    }
}
