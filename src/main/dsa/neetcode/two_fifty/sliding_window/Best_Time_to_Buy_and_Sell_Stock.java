package src.main.dsa.neetcode.two_fifty.sliding_window;

public class Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{7, 2, 5, 3, 6, 1}));
    }

    public static int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (price < buyingPrice) {
                buyingPrice = price;
            } else {
                res = Math.max(price - buyingPrice, res);
            }
        }
        return res;
    }
}
