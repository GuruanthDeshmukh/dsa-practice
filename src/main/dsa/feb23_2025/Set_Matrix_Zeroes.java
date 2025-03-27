package src.main.dsa.feb23_2025;

public class Set_Matrix_Zeroes {

    public static void main(String[] args) {
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        printMatrix(matrix1);
        System.out.println();
        setZeroes(matrix1);
        printMatrix(matrix1);
        System.out.println();
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        printMatrix(matrix2);
        System.out.println();
        setZeroes(matrix2);
        printMatrix(matrix2);
        System.out.println();
        int[][] matrix3 = {{0,1}};
        printMatrix(matrix3);
        System.out.println();
        setZeroes(matrix3);
        printMatrix(matrix3);
        System.out.println();
        int[][] matrix4 = {{1, 0}};
        printMatrix(matrix4);
        System.out.println();
        setZeroes(matrix4);
        printMatrix(matrix4);
        System.out.println();
    }

    private static void printMatrix(int[][] matrix1) {
        for (int[] ints : matrix1) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        boolean colZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0)
                rowZero = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                colZero = true;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                int j = 1;
                while (j < matrix[i].length) {
                    matrix[i][j] = 0;
                    j++;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                int j = 1;
                while (j < matrix.length) {
                    matrix[j][i] = 0;
                    j++;
                }
            }
        }

        if (rowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
