class Solution:
    def maxArea(self, heights: List[int]) -> int:
        def calcAmount(left: int, right: int, width: int) -> int:
            return min(left, right) * width
        
        l = 0
        r = len(heights) - 1
        max_amount = 0

        while l < r:

            amount = (r - l) * min(heights[r], heights[l])
            if amount > max_amount:
                max_amount = amount
            if heights[r] >= heights[l]:
                l += 1
            else:
                r -= 1
        return max_amount
            