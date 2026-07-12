import collections
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums_counter = collections.Counter(nums)
        return [num for num, cnt in nums_counter.most_common(k)]