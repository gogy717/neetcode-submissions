class Solution:
    def trap(self, height: list[int]) -> int:
        if len(height) < 3:
            return 0

        l, r = 0, len(height) - 1
        total = 0
        lw_i, rw_i = 0, len(height) - 1
        
        while l <= r:
            if height[lw_i] < height[rw_i]:
                if height[l] >= height[lw_i]:
                    lw_i = l
                else:
                    total += min(height[lw_i], height[rw_i]) - height[l]
                l += 1
            else:
                if height[r] >= height[rw_i]:
                    rw_i = r
                else:
                    total += min(height[lw_i], height[rw_i]) - height[r]
                r -= 1
        return total