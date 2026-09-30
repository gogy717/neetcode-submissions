class Solution {
    public int rob(int[] nums) {
        int[] robCache = new int[nums.length + 1];
        Arrays.fill(robCache, -1);
        return dp(0, nums, robCache);
    }
    
    private int dp(int i, int[] nums, int[] cache) {
        int l = nums.length;
        if (i >= l) return 0;
        if (i == l - 1) return nums[i];
        
        if (cache[i] != -1) return cache[i];
        int tmp = Math.max(dp(i + 1, nums, cache), dp(i + 2, nums, cache) + nums[i]);
        cache[i] = tmp;
        return cache[i];
    }
}



