class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(s, 0, path, result);

        return result;
    }

    private void backtrack(
        String s,
        int start,
        List<String> path,
        List<List<String>> result
    ) {
        // 已经把整个字符串切完了
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 尝试从 start 开始的所有 substring
        for (int end = start; end < s.length(); end++) {

            String window = s.substring(start, end + 1);

            if (!isPalindrome(window)) {
                continue;
            }

            // choose
            path.add(window);

            // explore
            backtrack(s, end + 1, path, result);

            // unchoose
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}