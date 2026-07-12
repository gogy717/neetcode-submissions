class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # # naive O(n^2)
        # max_counter = 0
        # for num in nums:
        #     if num - 1 not in nums:
        #         counter = 1
        #         next = num + 1
        #         while next in nums:
        #             next += 1
        #             counter += 1
        #         max_counter = max(max_counter, counter)
        # return max_counter
        
        # O(n) Time & Space
        nums_set = set(nums)

        max_cnt = 0
        while nums_set:
            t = next(iter(nums_set))  # 随便取一个元素

            # 向左找到序列的起点
            while t - 1 in nums_set:
                t -= 1

            # 从起点向右计数，边数边删除
            cnt = 0
            while t in nums_set:
                nums_set.remove(t)
                t += 1
                cnt += 1

            max_cnt = max(cnt, max_cnt)

        return max_cnt