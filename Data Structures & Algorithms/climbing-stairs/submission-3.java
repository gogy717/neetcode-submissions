class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return dp(n, cache);
    }

    private int dp(int n, int[] cache) {
        if (n <= 1) return 1;
        if (cache[n] != 0) return cache[n];
        cache[n] = dp(n - 1, cache) + dp(n - 2, cache);
        return cache[n];
    }
}
