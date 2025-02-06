package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

public class D007_Stock_Buy_and_Sell___Multiple_Transaction_Allowed {

    public static void main(String[] args) {
        System.out.println(maximumProfit(new int[]{100, 180, 260, 310, 40, 535, 695}));
        System.out.println(maximumProfit(new int[]{4, 2, 2, 2, 4}));
    }

    public static int maximumProfit(int[] prices) {
        // code here
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }

}
