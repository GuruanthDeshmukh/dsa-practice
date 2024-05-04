package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays3;

public class SeacrhIn2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {
                {1,3,5,7}
                ,{10,11,16,20}
                ,{23,30,34,60}
        }, Integer.parseInt("30")));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
// 1,3
// ,5,7,10
// ,11,16,20,23,30,34,60
        while (end >= start) {
            int mid = (start + end) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return false;
    }

//    public static boolean test (int[][] matrix, int target) {
//        int n=matrix.length;
//        int m=matrix[0].length;
//        int row=0, col=m-1;
//        //1,3,5,7
//        //10,11,16,20
//        //23,30,34,60
//        while(row<n && col>=0){
//            if(matrix[row][col]==target){
//                return true;
//            }
//            else if(matrix[row][col]>target){
//                col--;
//            }
//            else{
//                row++;
//            }
//        }
//        return false;
//    }
}
