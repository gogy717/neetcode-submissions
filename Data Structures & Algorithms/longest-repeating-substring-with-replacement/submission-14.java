class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxWindow = 0;
        int l = 0;
        int maxCount = 0;

        for (int r = 0; r < s.length(); r++) {
            char cr = s.charAt(r);
            int index = cr - 'A';
            count[index]++;
            maxCount = Math.max(maxCount, count[index]);
            while(r - l + 1 - maxCount > k) {
                char cl = s.charAt(l);
                int indexL = cl - 'A';
                count[indexL]--;
                l++;
            }
            maxWindow = Math.max(maxWindow, r - l + 1);
        }
        return maxWindow;
    }
}
