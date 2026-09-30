class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);       // 奇数长度：中心是 s[i]
            count += expand(s, i, i + 1);   // 偶数长度：中心在 s[i] 和 s[i+1] 之间
        }
        return count;
    }

    // 从 [l, r] 往两边扩，每扩成功一步就多找到一个回文
    private int expand(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}