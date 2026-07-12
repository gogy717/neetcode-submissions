import collections
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums_hash = collections.defaultdict(int)
        for n in nums:
            nums_hash[n] += 1
        
        # sort by values
        nums_hash_sorted = sorted(nums_hash.items(), key = lambda x: x[1], reverse = True)
        return [num for num, count in nums_hash_sorted[:k]]