package 链表相关问题;
/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // ListNode newList = new ListNode(-1);
        // ListNode p = newList;
        // ListNode l1 = list1;
        // ListNode l2 = list2;
        
        // while(l1 != null && l2 != null) {
        //     if(l1.val < l2.val) {
        //         p.next = l1;
        //         l1 = l1.next;
        //     } else {
        //         p.next = l2;
        //         l2 = l2.next;
        //     }
        //     p = p.next;
        // }

        // if(l1 != null) {
        //     p.next = l1;
        // }

        // if(l2 != null) {
        //     p.next = l2;
        // }

        // return newList.next;

        ListNode head = new ListNode();

        if(list1 == null && list2 == null) {
            return null;
        }

        if(list1 == null) {
            return list2;
        } 
        
        if(list2 == null) {
            return list1;
        }

        if(list1.val < list2.val) {
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }

        return head;
    }
}
// @lc code=end

