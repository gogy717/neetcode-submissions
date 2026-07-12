from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        word_map = defaultdict(list)
        for word in strs:
            ltr_cnt = [0] * 26
            for l in word:
                ltr_cnt[ord(l) - ord("a")] += 1
            word_map[tuple(ltr_cnt)].append(word)
        
        return list(word_map.values())