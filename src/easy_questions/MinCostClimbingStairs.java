package easy_questions;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i = 2; i < cost.length + 1; i++) {
            minCost[i] = Integer.min(minCost[i - 1], minCost[i - 2]);
            if (i == cost.length) {
                continue;
            }
            minCost[i] += cost[i];
        }
        return minCost[cost.length];
    }
}
