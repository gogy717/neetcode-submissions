class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = float("inf")
        sell = 0
        max_prof = 0
        for i, price in enumerate(prices):
            if price < buy:
                buy = price
                continue
            sell = price
            prof = sell - buy
            max_prof = max(prof, max_prof)
            
        return max_prof
                