package easy_questions;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Integer.min(cost[i - 1], cost[i - 2]);
        }
        return Integer.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
