class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(dp(0, cost, cache), dp(1, cost, cache));
    }

    private int dp(int i, int[] cost, int[] cache) {
        if (i >= cost.length) return 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = cost[i] + Math.min(dp(i + 1, cost, cache), dp(i + 2, cost, cache));
    }
}