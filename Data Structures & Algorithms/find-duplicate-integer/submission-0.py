class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # hash
        nmap = set()
        for n in nums:
            if n in nmap:
                return n
            nmap.add(n)


