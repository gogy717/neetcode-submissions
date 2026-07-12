import collections
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_cnt = 0
        letters = [0] * 26
        for i in range(k):
            letters[ord(s[i].lower()) - 97] += 1

        l, r = 0, k - 1
        while r < len(s) - 1:

            if sum(letters) - max(letters) <= k:
                max_cnt = max(r - l + 1, max_cnt)
                r += 1
                letters[ord(s[r].lower()) - 97] += 1
                
            else:
                letters[ord(s[l].lower()) - 97] -= 1
                l += 1
        if sum(letters) - max(letters) <= k:
            max_cnt = max(r - l + 1, max_cnt)   
        return max_cnt