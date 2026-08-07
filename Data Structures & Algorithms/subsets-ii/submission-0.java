class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, subset, result);
        return result;
    }

    private void backtrack(
        int[] nums,
        int start,
        List<Integer> subset,
        List<List<Integer>> result
    ) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            // 同一递归层中，相同数字只作为一次分支起点
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}