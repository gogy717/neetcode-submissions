from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # hash
        nums_hash = {}
        for i, n in enumerate(nums):
            rest = target - n
            if rest in nums_hash:
                return [nums_hash[rest], i]
            nums_hash[n] = i
