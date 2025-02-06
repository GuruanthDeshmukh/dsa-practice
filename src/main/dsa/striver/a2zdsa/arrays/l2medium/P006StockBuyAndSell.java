package src.main.dsa.striver.a2zdsa.arrays.l2medium;

public class P006StockBuyAndSell {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int buyingValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < buyingValue) {
                buyingValue = price;
            } else {
                maxProfit = Math.max(maxProfit, price - buyingValue);
            }
        }
        return maxProfit;
    }

}
