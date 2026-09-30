class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] P = new boolean[n][n];   // P[i][j]：s[i..j] 是不是回文
        int start = 0, maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {         // i 从大到小
            for (int j = i; j < n; j++) {          // j 从小到大
                // 两端相等，并且里面是回文（长度 ≤ 3 时里面最多一个字符，一定是回文）
                P[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[i + 1][j - 1]);
                if (P[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}