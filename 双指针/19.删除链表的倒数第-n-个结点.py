#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第 N 个结点
#


# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def removeNthFromEnd(self, head: Optional[ListNode],
                         n: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head

        slow, fast = dummy, dummy

        step = n + 1
        while step:
            fast = fast.next
            step -= 1
            
        while fast:
            slow = slow.next
            fast = fast.next

        slow.next = slow.next.next

        return dummy.next


# @lc code=end
