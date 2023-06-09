package easy_questions;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int minHold = Integer.MAX_VALUE;
        int maxProfit = 0;
        int totalProfit = 0;
        for (int price : prices) {
            minBuy = Integer.min(minBuy, price);
            minHold = Integer.min(minHold, minBuy);
            // maxProfit = Integer.max(maxProfit, price - minHold);
            if (price - minHold < maxProfit) {
                totalProfit += maxProfit;
                maxProfit = 0;
                minHold = price;
                minBuy = price;
            } else {
                maxProfit = price - minHold;   
            }
        }
        return totalProfit + maxProfit;
    }
}
