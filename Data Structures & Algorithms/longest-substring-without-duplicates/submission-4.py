import collections
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}
        l = 0
        length = 0

        for i in range(len(s)):
            if s[i] in char_index and char_index[s[i]] >= l:
                l = char_index[s[i]] + 1
            else:
                len_tmp = i - l + 1
                length = max(length, len_tmp)
            char_index[s[i]] = i
        
        return length

