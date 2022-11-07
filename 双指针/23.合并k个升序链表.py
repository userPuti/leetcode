#
# @lc app=leetcode.cn id=23 lang=python3
#
# [23] 合并K个升序链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from heapq import heappop, heappush


class Solution:

    def mergeKLists(self,
                    lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        p = dummy
        hp = []
        for node in lists:
            while node:
                heappush(hp, node.val)
                node = node.next

        while hp:
            s_node = heappop(hp)
            p.next = ListNode(s_node)
            p = p.next
        
        return dummy.next

# @lc code=end
