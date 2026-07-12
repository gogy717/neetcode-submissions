class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = len(nums)
        left, right = 0, l - 1
        mid = (left + right) // 2

        while left <= right:
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
            mid = (left + right) // 2
        return -1 
