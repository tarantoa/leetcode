class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int curMin = prices[0];
        for (int idx = 1; idx < prices.length; ++idx) {
            if (prices[idx] < curMin) {
                curMin = prices[idx];
            } else {
                maxProfit = Math.max(maxProfit, prices[idx] - curMin);
            }
        }
        
        return Math.max(0, maxProfit);
    }
}