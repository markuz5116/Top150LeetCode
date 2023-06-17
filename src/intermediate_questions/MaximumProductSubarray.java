package intermediate_questions;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currMin = 1;
        int currMax = 1;
        int maxProd = Integer.MIN_VALUE;
        for (int num : nums) {
            int tempMin = currMin * num;
            int tempMax = currMax * num;
            currMin = Integer.min(tempMin, Integer.min(tempMax, num));
            currMax = Integer.max(tempMax, Integer.max(tempMin, num));
            maxProd = Integer.max(currMax, maxProd);
        }
        return maxProd;
    }
}
