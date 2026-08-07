class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int maxWindow = 0;
        for (int r = 0; r < s.length(); r++) {
            char cr = s.charAt(r);
            window.put(cr, window.getOrDefault(cr, 0) + 1);

            int maxCount = 0;
            int remain = 0;

            for (Map.Entry<Character, Integer> entry: window.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                }                
            }
            remain = r - l + 1 - maxCount;
            if (remain <= k) {
                maxWindow = Math.max(maxWindow, r - l + 1);
                continue;
            } else {
                char cl = s.charAt(l);
                window.put(cl, window.get(cl) - 1);
                l++;
            }

        }
        return maxWindow;

    }
}
