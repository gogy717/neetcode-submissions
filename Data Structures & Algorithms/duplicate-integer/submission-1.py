class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        nums_hash = set()
        for n in nums:
            if n not in nums_hash:
                nums_hash.add(n)
            else:
                return True
        return False