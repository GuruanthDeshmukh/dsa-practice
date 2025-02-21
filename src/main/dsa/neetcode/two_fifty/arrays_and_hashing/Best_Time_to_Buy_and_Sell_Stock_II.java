package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitV2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        int buyingPrice = Integer.MAX_VALUE;
        int sellingValue = -1;
        int i = 0;
        while (i < prices.length) {
            int price = prices[i];
            if (price < buyingPrice) {
                buyingPrice = price;
                i++;
                continue;
            } else if (price > sellingValue) {
                int j = i;
                while (j < prices.length - 1 && prices[j] < prices[j + 1]) {
                    j++;
                }
                sellingValue = prices[j];
                res += sellingValue - buyingPrice;
                buyingPrice = Integer.MAX_VALUE;
                sellingValue = -1;
                i = j + 1;
                continue;
            }
            i++;
        }
        return res;
    }

    public static int maxProfitV2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
