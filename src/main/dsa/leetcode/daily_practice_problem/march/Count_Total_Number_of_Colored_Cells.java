package src.main.dsa.leetcode.daily_practice_problem.march;

public class Count_Total_Number_of_Colored_Cells {

    public static void main(String[] args) {
        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));
        System.out.println(coloredCells(3));
        System.out.println(coloredCells(4));
        System.out.println(coloredCells(5));
        System.out.println(coloredCells(569675));
        System.out.println(coloredCellsV2(569675));
    }

    public static long coloredCells(int n) {
//        long res = 1;
//
//        for (int i = 1; i < n; i++) {
//            res += 4*i;
//        }
//
//        return res;
//        return 1 + (long)2*(n*(n-1));
        return 1 + (long) 2 * n * (n - 1);
    }


    public static long coloredCellsV2(int n) {
        long res = 1;

        for (int i = 1; i < n; i++) {
            res += 4L * i;
        }

        return res;
    }


}
