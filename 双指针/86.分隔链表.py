#
# @lc app=leetcode.cn id=86 lang=python3
#
# [86] 分隔链表
#


# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def partition(self, head: Optional[ListNode],
                  x: int) -> Optional[ListNode]:
        dum_ls, dum_gt = ListNode(-1), ListNode(-1)
        p1, p2 = dum_ls, dum_gt
        p = head

        while p:
            if p.val < x:
                p1.next = p
                p1 = p1.next
            else:
                p2.next = p
                p2 = p2.next
            
            temp = p.next
            p.next = None
            p = temp
        
        p1.next = dum_gt.next

        return dum_ls.next

# @lc code=end
