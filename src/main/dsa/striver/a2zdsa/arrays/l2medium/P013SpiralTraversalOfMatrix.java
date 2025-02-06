package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.ArrayList;
import java.util.List;

public class P013SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        System.out.println(spiralMatrixV5(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}

//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}

//                {1,2}
//                {1},{2}

//                {2,5,8},
//                {4,0,-1}

//                {3},{2}
        }));
    }

    public static List<Integer> spiralMatrix(int[][] arr) {
        List<Integer> resp = new ArrayList<>();
        if (arr.length == 0)
            return resp;
        if (arr.length == 1) {
            for (int i = 0; i < arr[0].length; i++) {
                resp.add(arr[0][i]);
            }
            return resp;
        }
        int start = 0;
        int end = arr[start].length;
        int colend = arr.length;
        while (start < end) {
            int i = start;
            int j = start;
            while (j < end) {
                resp.add(arr[i][j]);
                j++;
            }
            j--;
            i++;
            while (i < colend) {
                resp.add(arr[i][j]);
                i++;
            }
            i--;
            j--;
            while (j > start) {
                resp.add(arr[i][j]);
                j--;
            }
            while (i > start) {
                resp.add(arr[i][j]);
                i--;
            }
            start++;
            end--;
            colend--;
        }
        return resp;
    }

    public static List<Integer> spiralMatrixV2(int[][] arr) {
        List<Integer> resp = new ArrayList<>();
        if (arr.length == 0)
            return resp;
        if (arr.length == 1) {
            for (int i = 0; i < arr[0].length; i++) {
                resp.add(arr[0][i]);
            }
            return resp;
        }
        int a = 0, b = arr[0].length - 1, c = arr.length - 1, d = 0;

        int i = 0, j = 0;

        while (i <= b && j <= c) {
            j = a;
            i = a;
            a++;
            while (j <= b) {
                resp.add(arr[i][j]);
                j++;
            }
            j--;
            b--;
            i++;
            if (a < c) {
                while (i <= c) {
                    resp.add(arr[i][j]);
                    i++;
                }
            }
            c--;
            i--;
            j--;
            if (d < b) {
                while (j >= d) {
                    resp.add(arr[i][j]);
                    j--;
                }
            }
            d++;
            j++;
            i--;
            while (i >= a) {
                resp.add(arr[i][j]);
                i--;
            }
        }

        return resp;
    }

    public static List<Integer> spiralMatrixV3(int[][] arr) {
        List<Integer> resp = new ArrayList<>();

        int top = 0, left = 0, bottom = arr.length, right = arr[0].length;

        while (left < right && top < bottom) {
            int i = top;
            int j = left;

            while (j < right) {
                resp.add(arr[top][j]);
                j++;
            }
            i++;
            while (i < bottom) {
                resp.add(arr[i][right - 1]);
                i++;
            }
            j--;
            j--;
            if (left <= bottom) {
                while (j >= left) {
                    resp.add(arr[bottom - 1][j]);
                    j--;
                }
            }
            i--;
            i--;
            if (top <= right) {
                while (i > top) {
                    resp.add(arr[i][top]);
                    i--;
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }

        return resp;
    }

    public static List<Integer> spiralMatrixV4(int[][] arr) {
        List<Integer> resp = new ArrayList<>();

        int top = 0, left = 0, bottom = arr.length, right = arr[0].length;

        while (left < right && top < bottom) {
            int i = top;
            int j = left;
            int a = top, b = left, c = bottom, d = right;

            while (j < right) {
                resp.add(arr[a][j]);
                j++;
            }
            top++;
            i++;
            while (i < bottom) {
                resp.add(arr[i][d - 1]);
                i++;
            }
            right--;
            j--;
            j--;
            if (left < bottom) {
                while (j >= left) {
                    resp.add(arr[c - 1][j]);
                    j--;
                }
            }
            bottom--;
            i--;
            i--;
            if (top < right) {
                while (i > top) {
                    resp.add(arr[i][b]);
                    i--;
                }
            }
            left++;
        }

        return resp;
    }

    public static List<Integer> spiralMatrixV5(int[][] arr) {
        List<Integer> resp = new ArrayList<>();

        int top = 0, left = 0, bottom = arr.length - 1, right = arr[0].length - 1;

        while (top <= bottom && left <= right) {
            int i = top;
            while (i <= right) {
                resp.add(arr[top][i]);
                i++;
            }
            top++;
            i = top;
            while (i <= bottom) {
                resp.add(arr[i][right]);
                i++;
            }
            right--;
            if (top < bottom) {
                i = right;
                while (i >= left) {
                    resp.add(arr[bottom][i]);
                    i--;
                }
                bottom--;
            }
            if (left < right) {
                i = bottom;
                while (i >= top) {
                    resp.add(arr[i][left]);
                    i--;
                }
                left++;
            }

        }

        return resp;
    }
}
