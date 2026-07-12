import collections
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        window_size = 0
        letters = [0] * 26

        l = 0

        for r in range(len(s)):
            letters[ord(s[r].lower()) - 97] += 1

            if sum(letters) - max(letters) <= k:
                window_size += 1
            else:
                letters[ord(s[l].lower()) - 97] -= 1
                l += 1                

        return window_size


