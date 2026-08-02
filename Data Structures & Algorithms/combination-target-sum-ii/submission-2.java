class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, target, path, result);

        return result;
    }
    private void backtrack(int[] candidates, int start, int sum, int target, List<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            // if path not in result;
            if (!result.contains(path)){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, i + 1, sum, target, path, result);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
