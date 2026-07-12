from collections import Counter
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        count1 = Counter(s1)
        count2 = Counter(s2[:len(s1)])  # 初始化第一个窗口

        if count1 == count2:
            return True

        for i in range(len(s1), len(s2)):
            count2[s2[i]] += 1          # 右边新加一个字符
            
            left = s2[i - len(s1)]
            count2[left] -= 1           # 左边移出一个字符
            if count2[left] == 0:
                del count2[left]        # 避免 {a:0} 干扰比较
            
            if count1 == count2:
                return True

        return False