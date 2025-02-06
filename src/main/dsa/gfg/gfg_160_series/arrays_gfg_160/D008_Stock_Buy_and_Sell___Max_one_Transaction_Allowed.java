package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

public class D008_Stock_Buy_and_Sell___Max_one_Transaction_Allowed {

    public static void main(String[] args) {
        System.out.println(maximumProfit(new int[]{7, 10, 1, 3, 6, 9, 2}));
        System.out.println(maximumProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maximumProfit(new int[]{1, 3, 6, 9, 11}));
        System.out.println(maximumProfit(new int[]{61, 44, 70, 78, 73, 95, 27, 1}));
    }

    public static int maximumProfit(int[] prices) {
        // Code here
        int res = 0;
        int temp = 0;
        int buyingPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < buyingPrice) {
                buyingPrice = price;
                res = Math.max(res, temp);
                temp = 0;
            } else {
                temp = Math.max(price - buyingPrice, temp);
            }
        }
        res = Math.max(res, temp);
        return res;
    }

}
