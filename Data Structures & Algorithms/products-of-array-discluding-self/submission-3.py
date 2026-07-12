class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix_arr = [1]
        sufix_arr = [1]
        for i in range(len(nums) - 1):
            prefix_arr.append(prefix_arr[-1] * nums[i])
            sufix_arr.append(sufix_arr[-1] * nums[-i - 1])
        
        sufix_arr = sufix_arr[::-1]

        result = [sufix_arr[j] * prefix_arr[j] for j in range(len(nums))]
        return result
