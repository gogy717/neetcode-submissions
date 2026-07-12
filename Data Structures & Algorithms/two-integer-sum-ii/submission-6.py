import collections
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        seen = collections.defaultdict(List[int])
        for i, num in enumerate(numbers):
            remainder = target - num
            if remainder in seen:
                return [seen[remainder], i + 1]
            seen[num] = i + 1
            
        return []


