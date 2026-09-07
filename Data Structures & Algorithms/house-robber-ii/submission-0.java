class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // Rob houses from 0 to n-2
        int max1 = robLinear(nums, 0, nums.length - 2);
        
        // Rob houses from 1 to n-1
        int max2 = robLinear(nums, 1, nums.length - 1);
        
        // Return the maximum of the two scenarios
        return Math.max(max1, max2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }
    
}
