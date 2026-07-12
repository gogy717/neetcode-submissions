class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_str = ""
        for word in strs:
            len_ht_word = str(len(word)) + "#" + word
            encoded_str += len_ht_word
        return encoded_str
            
    def decode(self, s: str) -> List[str]:
        i = 0
        result = []
        while i < len(s):
            j = s.index("#", i)
            length = int(s[i:j])
            result.append(s[j+1 : j+1+length])
            i = j + 1 + length         # 移动指针
        return result
            
        