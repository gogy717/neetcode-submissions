import collections
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}  # 记录每个字符最近出现的 index
        l = 0
        max_len = 0
        
        for r in range(len(s)):
            # 如果 s[r] 在当前窗口内出现过
            if s[r] in char_index and char_index[s[r]] >= l:
                l = char_index[s[r]] + 1  # l 跳到重复字符的下一位
            
            char_index[s[r]] = r          # 更新最新位置
            max_len = max(max_len, r - l + 1)
        
        return max_len