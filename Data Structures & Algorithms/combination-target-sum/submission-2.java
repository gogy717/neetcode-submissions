class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, 0, target, path, result);

        return result;
    }
    
    private void backtrack(int[] nums, int start, int sum, int target, List<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            backtrack(nums, i, sum, target, path, result);  
            sum -= nums[i];
            path.remove(path.size() - 1);
        }
    }
}
