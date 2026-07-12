class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s:
            return ""
        
        need = {}
        for c in t:
            need[c] = need.get(c, 0) + 1
        
        required = len(need)  # t 中不同字符的种数
        formed = 0            # 当前窗口已满足的字符种数
        window = {}
        
        left = 0
        res = ""
        res_len = float("inf")
        
        for right in range(len(s)):
            # 扩张右边
            c = s[right]
            window[c] = window.get(c, 0) + 1
            
            # 判断当前字符是否满足需求
            if c in need and window[c] == need[c]:
                formed += 1
            
            # 尝试收缩左边
            while formed == required:
                # 更新结果
                if right - left + 1 < res_len:
                    res_len = right - left + 1
                    res = s[left:right + 1]
                
                # 收缩
                left_c = s[left]
                window[left_c] -= 1
                if left_c in need and window[left_c] < need[left_c]:
                    formed -= 1
                left += 1
        
        return res