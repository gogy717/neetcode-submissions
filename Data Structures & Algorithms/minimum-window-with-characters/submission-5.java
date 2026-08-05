
class Solution {
    public String minWindow(String s, String t) {
        // 空字符串不可能产生答案
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        /*
         * need：目标字符频率表（frequency map）
         *
         * 例如 t = "AABC"
         * need = {A=2, B=1, C=1}
         */
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        /*
         * window：当前窗口 [left, right] 中，每个字符出现的次数
         */
        Map<Character, Integer> window = new HashMap<>();

        /*
         * required：需要满足的字符种类数量
         *
         * t = "AABC"
         * required = 3，因为需要满足 A、B、C 三种字符
         */
        int required = need.size();

        /*
         * formed：当前窗口已经满足的字符种类数量
         *
         * 注意：统计的是“种类”，不是字符总数。
         */
        int formed = 0;

        // 滑动窗口左边界
        int left = 0;

        // 最佳答案的起点和长度
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        /*
         * right 不断向右移动，扩张窗口（expand window）
         */
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // 把 current 加入窗口
            window.put(
                current,
                window.getOrDefault(current, 0) + 1
            );

            /*
             * 如果 current 是目标字符，并且加入后数量刚好达到要求，
             * 那么又有一种字符被完全满足。
             *
             * 必须使用 ==，不能使用 >=。
             * 否则字符超额出现时，formed 会被重复增加。
             */
            if (
                need.containsKey(current)
                && window.get(current).intValue()
                    == need.get(current).intValue()
            ) {
                formed++;
            }

            /*
             * formed == required：
             * 当前窗口已经包含 t 所需要的全部字符。
             *
             * 此时尝试移动 left，缩小窗口（shrink window）。
             */
            while (formed == required) {
                int currentLength = right - left + 1;

                // 当前窗口比历史答案更短，更新答案
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestStart = left;
                }

                // 准备移除左边字符
                char removed = s.charAt(left);

                window.put(
                    removed,
                    window.get(removed) - 1
                );

                /*
                 * 如果 removed 是目标字符，并且移除后数量低于要求，
                 * 当前窗口就不再满足这种字符。
                 */
                if (
                    need.containsKey(removed)
                    && window.get(removed) < need.get(removed)
                ) {
                    formed--;
                }

                // 真正移动左边界
                left++;
            }
        }

        // 没找到有效窗口
        if (bestLength == Integer.MAX_VALUE) {
            return "";
        }

        // substring 的结束位置不包含在结果中，所以要加 bestLength
        return s.substring(bestStart, bestStart + bestLength);
    }
}