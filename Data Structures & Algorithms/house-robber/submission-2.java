

class Solution {
    public int rob(int[] nums) {
        int[] maxLoot = new int[nums.length];
        Arrays.fill(maxLoot, -1);

        return dp(nums, 0, maxLoot, 0);

    }

    private int dp(int[] nums, int loot, int[] maxLoot, int i) {
    if (i >= nums.length) {
        return loot;
    }

    // 如果以前到达 i 时携带的钱更多，当前路线就没有继续搜索的必要
    if (loot <= maxLoot[i]) {
        return loot;
    }

    maxLoot[i] = loot;

    // 不偷第 i 间房
    int skip = dp(nums, loot, maxLoot, i + 1);

    // 偷第 i 间房
    int take = dp(
        nums,
        loot + nums[i],
        maxLoot,
        i + 2
    );

    return Math.max(skip, take);
}
}
