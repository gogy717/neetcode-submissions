class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        minimum = float('inf')
        m = (l + r) // 2

        while l < r:
            if nums[m] < nums[r]:
                minimum = min(nums[l], minimum)
                r = m
            elif nums[m] > nums[r]:
                l = m + 1
            m = (l + r) // 2
        
        return nums[m]
            