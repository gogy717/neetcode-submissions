class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, path, result);

        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        for(int i = 0; i < nums.length; i++) {
            // 已经选完所有数字，得到一个完整排列
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, path, result);
                path.remove(path.size() - 1);
                used[i] = false;
            }
            
        }
    }
}
