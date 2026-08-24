class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        return Math.min(dp(cost, 0, cache), dp(cost, 1, cache));
    }

    private int dp(int[] cost, int pos, int[] cache) {
        // Reached or passed the top: no more cost to pay.
        if (pos >= cost.length) {
            return 0;
        }

        if (cache[pos] != 0) {
            return cache[pos];
        }

        cache[pos] = cost[pos] + Math.min(
            dp(cost, pos + 1, cache),
            dp(cost, pos + 2, cache)
        );

        return cache[pos];
    }
}