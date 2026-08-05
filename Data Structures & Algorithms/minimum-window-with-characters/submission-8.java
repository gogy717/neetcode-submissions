class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need =  new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int minWindowL = Integer.MAX_VALUE;
        int minWindowLeft = 0;
        int required = need.size();
        int have = 0;

        for (int r = 0; r < s.length(); r ++) {

            char rc = s.charAt(r);
            if (!need.containsKey(rc)) {
                continue;
            }
            window.put(rc, window.getOrDefault(rc, 0) + 1);
            if (window.get(rc) == need.get(rc)) {
                have += 1;
            }
            while (have == required) {
                int curLength = r - l + 1;
                if (curLength < minWindowL) {
                    minWindowL = curLength;
                    minWindowLeft = l;
                }

                char lc = s.charAt(l);
                if (need.containsKey(lc)) {
                    window.put(lc, window.get(lc) - 1);
                    if (window.get(lc) < need.get(lc)) {
                        have -=1;
                    }
                }

                l ++;
            }
        }
        if (minWindowL == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minWindowLeft, minWindowLeft + minWindowL);
    }
}
