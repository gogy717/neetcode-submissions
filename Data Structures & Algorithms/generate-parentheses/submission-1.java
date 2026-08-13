class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder path = new StringBuilder();
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, path, result);
        return result;
    }

    private void backtrack(int n, int lp, int rp, StringBuilder path, List<String> result) {
        // TODO
        if (rp == n) {
            result.add(path.toString());
            return;
        }

        if (lp < n) {
            path.append("(");
            backtrack(n, lp + 1, rp, path, result);
            path.deleteCharAt(path.length() - 1);
            if (rp < lp) {
                path.append(")");
                backtrack(n, lp, rp + 1, path, result);
                path.deleteCharAt(path.length() - 1);
            }
        }

        if (lp == n) {
            path.append(")");
            backtrack(n, lp, rp + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
