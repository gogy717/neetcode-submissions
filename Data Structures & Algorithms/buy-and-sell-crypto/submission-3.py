class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = float("inf")
        max_prof = 0
        for price in prices:
            if price < buy:
                buy = price
            else:
                prof = price - buy
                max_prof = max(prof, max_prof)
            
        return max_prof
                