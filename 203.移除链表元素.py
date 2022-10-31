#
# @lc app=leetcode.cn id=203 lang=python3
#
# [203] 移除链表元素
#


# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def removeElements(self, head: Optional[ListNode],
                        val: int) -> Optional[ListNode]:
        p = ListNode(-1, head)
        ans = p

        while p.next:
            if p.next.val == val:
                p.next = p.next.next
            else:
                p = p.next

        return ans.next
# @lc code=end
