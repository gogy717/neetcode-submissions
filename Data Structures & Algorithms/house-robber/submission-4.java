class Solution {
    public int rob(int[] nums) {
        int[] max_sum = new int[nums.length];
        Arrays.fill(max_sum, -1);
        return dp(nums, 0, max_sum, 0);
    }

    private int dp(int[] nums, int index, int[] max_sum, int max_now) {
        if (index > nums.length - 1)
            return max_now;
        if (max_now <= max_sum[index])
            return max_now;
        
        max_sum[index] = max_now;

        int skip = dp(nums, index + 1, max_sum, max_now);
        int nSkip = dp(nums, index + 2, max_sum, max_now + nums[index]);
        return Math.max(skip, nSkip);
            
    }
}
