class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_str = ""
        for word in strs:
            word_plus_split = word + "[]"
            encoded_str += word_plus_split
        return encoded_str
            
    def decode(self, s: str) -> List[str]:
        s_list = s.split("[]")
        s_list.pop()
        return s_list
        