# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False
        l, r = head, head.next
        while l != r:
            if not r.next or not r.next.next:
                return False
            l = l.next
            r = r.next.next
        
        return True



