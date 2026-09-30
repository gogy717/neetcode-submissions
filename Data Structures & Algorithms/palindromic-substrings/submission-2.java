class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                boolean isEqual = s.charAt(i) == s.charAt(j);
                boolean isPalindrome = isEqual && ((j - i <= 2) || cache[i+1][j-1]);
                cache[i][j] = isPalindrome;
                if (isPalindrome) {
                    count++;
                }
            }
        }
        return count;

    }
}
