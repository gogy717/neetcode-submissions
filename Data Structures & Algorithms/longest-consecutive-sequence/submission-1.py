class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        max_counter = 0
        for num in nums:
            if num - 1 not in nums:
                counter = 1
                next = num + 1
                while next in nums:
                    next += 1
                    counter += 1
                max_counter = max(max_counter, counter)
        return max_counter
                
