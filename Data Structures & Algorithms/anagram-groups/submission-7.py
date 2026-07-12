class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        word_map = {}
        for word in strs:
            sorted_word = str(sorted(word))
            if sorted_word not in word_map:
                word_map[sorted_word] = [word]
            else:
                word_map[sorted_word].append(word)
        
        ans = []
        for wg in word_map.values():
            ans += wg
        return list(word_map.values())