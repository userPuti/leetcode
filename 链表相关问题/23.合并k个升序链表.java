package 链表相关问题;
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

import java.util.PriorityQueue;

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode res = head;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
        (l1, l2)->(l1.val - l2.val));

        for(ListNode temp : lists) {
            if(temp != null) {
                queue.add(temp);
            }
        }

        while(!queue.isEmpty()) {
            ListNode listTemp = queue.poll();
            head.next = listTemp;
            if(listTemp.next != null) {
                queue.add(listTemp.next);
            }
            head = head.next;
        }

        return res.next;
     }
}
// @lc code=end
