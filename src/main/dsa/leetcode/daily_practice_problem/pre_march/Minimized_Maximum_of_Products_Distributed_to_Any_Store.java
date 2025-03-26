package src.main.dsa.leetcode.daily_practice_problem.pre_march;

public class Minimized_Maximum_of_Products_Distributed_to_Any_Store {

    public static int minimizedMaximum(int n, int[] quantities) {
        int res = 0;
        int max_quantity = Integer.MIN_VALUE;
        for (int quantity : quantities) {
            if (quantity > max_quantity)
                max_quantity = quantity;
        }
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;

        }
        return res;
    }
}
