class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int minWindowLength = Integer.MAX_VALUE;

        int required = need.size();
        int formed = 0;

        int minWindowLeft = 0;

        for (int r = 0; r < s.length(); r ++) {
            char cur = s.charAt(r);
            if (!need.containsKey(cur)) {
                continue;
            }
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if (window.get(cur) == need.get(cur)) {
                formed ++;
            }
            
            char curL;
            while (formed == required) {
                int currentLength = r - l + 1;
                if (currentLength < minWindowLength) {
                    minWindowLength = currentLength;
                    minWindowLeft = l;
                }

                curL = s.charAt(l);
                if (window.containsKey(curL)) {
                    window.put(curL, window.get(curL) - 1);
                    if (window.get(curL) < need.get(curL)) {
                        formed --;
                    }
                }
                l ++;
            }

        }
        if (minWindowLength == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minWindowLeft, minWindowLeft + minWindowLength);
    }
}
