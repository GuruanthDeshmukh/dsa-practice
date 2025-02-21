package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

/*

Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
You must design an algorithm where sumRegion works on O(1) time complexity.



Example 1:


Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
-104 <= matrix[i][j] <= 104
0 <= row1 <= row2 < m
0 <= col1 <= col2 < n
At most 104 calls will be made to sumRegion.

 */
public class Range_Sum_Query_2D_Immutable {

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));


        //[[[[7,7,0],[-4,-7,7],[-4,0,-2],[-8,-5,6]]],[1,0,2,2],[3,2,3,2],[2,1,2,2],[0,2,2,2],[3,2,3,2]]
        //[null,-10,6,-2,5,6]
        NumMatrix numMatrix1 = new NumMatrix(new int[][]{{7, 7, 0},    // 7,   14, 14     //  7  14 14
                {-4, -7, 7},   // -4, -11, -4     //  3   3 10
                {-4, 0, -2},   // -4, -4,  -6     // -1  -1  4
                {-8, -5, 6}}); // -8, -13, -7     // -9 -14 -3
        System.out.println(numMatrix1.sumRegion(1, 0, 2, 2)); // -10
        System.out.println(numMatrix1.sumRegion(3, 2, 3, 2)); // 6
        System.out.println(numMatrix1.sumRegion(2, 1, 2, 2)); // -2
        System.out.println(numMatrix1.sumRegion(0, 2, 2, 2)); // 5
        System.out.println(numMatrix1.sumRegion(3, 2, 3, 2)); // 6
    }

    public static class NumMatrix {

        int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            this.prefixSum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                int sum = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j];
                    this.prefixSum[i][j] = sum;
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = prefixSum[0][j];
                for (int i = 1; i < matrix.length; i++) {
                    sum += prefixSum[i][j];
                    this.prefixSum[i][j] = sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = prefixSum[row2][col2];
            if (row1 == 0 && col1 == 0)
                return sum;

            if (row1 == 0)
                return sum - prefixSum[row2][col1 - 1];

            if (col1 == 0)
                return sum - prefixSum[row1 - 1][col2];

            return sum - prefixSum[row1 - 1][col2] - prefixSum[row2][col1 - 1]
                    + prefixSum[row1 - 1][col1 - 1];
        }
    }

}
