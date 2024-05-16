package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays;

import java.util.Arrays;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        Arrays.stream(arr).sequential().forEach(element -> System.out.print(element + " "));
        System.out.println();
        System.out.println("-x-x-x-");
        System.out.println(maxProfit(arr));
    }

    /**
     * <a href="https://www.youtube.com/watch?v=1pkOgXD63yU">Solution Video</a>
     *
     * @param prices Input array
     * @return Maximum profit.
     */
    public static int maxProfit(int[] prices) {
        int buyingValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (buyingValue > price)
                buyingValue = price;
            else
                maxProfit = Math.max(maxProfit, price - buyingValue);
        }
        return maxProfit;
    }
}
