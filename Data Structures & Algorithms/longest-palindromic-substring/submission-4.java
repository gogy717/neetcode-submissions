class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        int start = 0, maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {         // i 从大到小
            for (int j = i; j < n; j++) {
                cache[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || cache[i + 1][j - 1]);
                if (cache[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);

    }
}
