package easy_questions;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    // You are given an array prices where prices[i] is the price of a given stock
    // on the ith day.
    // You want to maximize your profit by choosing a single day to buy one stock
    // and choosing a different day in the future to sell that stock.
    // Return the maximum profit you can achieve from this transaction. If you
    // cannot achieve any profit, return 0.
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void test() {
        int[][] allPrices = new int[][] { { 7, 1, 5, 3, 6, 4 }, { 7, 6, 4, 3, 1 } };
        int[] allOutputs = new int[] { 5, 0 };
        boolean allPass = true;
        for (int i = 0; i < allPrices.length; i++) {
            int[] prices = allPrices[i];
            int output = allOutputs[i];
            int myOutput = BestTimeToBuyAndSellStock.maxProfit(prices);
            if (myOutput != output) {
                System.out.println(String.format("Input: %s", Arrays.toString(prices)));
                System.out.println(String.format("Your code gave: %s", myOutput));
                System.out.println(String.format("Correct output: %s", output));
                allPass = false;
            }
        }
        if (allPass) {
            System.out.println("All Correct");
        }
    }
}
