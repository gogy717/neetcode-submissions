class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # # hash
        # nmap = set()
        # for n in nums:
        #     if n in nmap:
        #         return n
        #     nmap.add(n)
        
        # # without extra space but altering the arr
        # for x in nums:

        #     idx = abs(x) - 1

        #     if nums[idx] < 0:

        #         return abs(x)

        #     nums[idx] *= -1
        
        # Floyd 
        slow = nums[0]

        fast = nums[0]

        # 第一步：找到相遇点

        while True:

            slow = nums[slow]

            fast = nums[nums[fast]]

            if slow == fast:

                break

        # 第二步：找到环入口

        slow = nums[0]

        while slow != fast:

            slow = nums[slow]

            fast = nums[fast]

        return slow


