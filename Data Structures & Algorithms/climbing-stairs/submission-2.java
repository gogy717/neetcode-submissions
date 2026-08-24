class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        int result = 0;
        result = dp(n, cache);
        return result;
    }

    private int dp(int n, int[] cache) {
        if (n <= 1) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = dp(n - 1, cache) + dp(n - 2, cache);
        return cache[n];

    }
}
