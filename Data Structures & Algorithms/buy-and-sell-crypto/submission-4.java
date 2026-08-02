class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = -1;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            profit = Math.max(prices[i] - buy, profit);
        }
        return profit;

    }
}
