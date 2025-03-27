package src.main.dsa.feb23_2025;

public class Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfitV2(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(maxProfit(new int[] {2,4,1}));
        System.out.println(maxProfit(new int[] {2,1,2,1,0,1,2}));
        System.out.println(maxProfit(new int[] {3,3,5,0,0,3,1,4}));
        System.out.println(maxProfitV2(new int[] {3,3,5,0,0,3,1,4}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyingPrice = Integer.MAX_VALUE;
        int sellingPrice = -1;
        for (int price : prices) {
            if (price < buyingPrice) {
                buyingPrice = price;
                sellingPrice = 0;
            } else if (sellingPrice <= price) {
                sellingPrice = price;
                profit = Math.max(profit, sellingPrice - buyingPrice);
            }
        }
        return sellingPrice == -1 ? 0 : profit;
    }
    public static int maxProfitV2(int[] prices) {
        int mini=prices[0];
        int profit=Integer.MIN_VALUE;
        for (int price : prices) {
            int cost = price - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, price);
        }
        return profit;
    }

}
