class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int l = 0;
        int r = 1;                 // substring(l, r) 不包含 r
        int maxL = 0, maxR = 1;
        int n = s.length();

        while (l < n) {
            if (r > n) {           // 当前 l 的所有右边界都试完了
                l++;
                r = l + 1;
                continue;
            }

            String tmp = s.substring(l, r);
            if (tmp.length() > maxR - maxL && isPalindrome(tmp)) {
                maxL = l;
                maxR = r;
            }
            r++;
        }

        return s.substring(maxL, maxR);
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
