class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 统计 t 中每个字符需要多少个
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int valid = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);

            // 右指针字符是我们需要的
            if (need.containsKey(rightChar)) {
                window.put(
                    rightChar,
                    window.getOrDefault(rightChar, 0) + 1
                );

                // 这个字符的数量刚好满足要求
                if (window.get(rightChar).equals(need.get(rightChar))) {
                    valid++;
                }
            }

            // 所有不同字符都满足要求
            while (valid == need.size()) {
                int currentLength = r - l + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    start = l;
                }

                char leftChar = s.charAt(l);

                // 左指针移走的是需要的字符
                if (need.containsKey(leftChar)) {
                    // 移走之前刚好满足要求，移走后就不满足了
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }

                    window.put(leftChar, window.get(leftChar) - 1);
                }

                l++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}