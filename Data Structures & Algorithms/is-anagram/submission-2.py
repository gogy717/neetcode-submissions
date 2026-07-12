
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        set_s = {}
        set_t = {}
        for n in range(len(s)):
            if s[n] not in set_s:
                set_s[s[n]] = 1
            else:
                set_s[s[n]] += 1
            if t[n] not in set_t:
                set_t[t[n]] = 1
            else:
                set_t[t[n]] += 1
            
        
        return set_t == set_s
        