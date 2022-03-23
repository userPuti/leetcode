import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */ 

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public void flatten(TreeNode root) {
        // if (root == null)
        // return;

        // fun1(root);

        // while (!queue.isEmpty()) {
        // TreeNode pre = queue.poll();
        // TreeNode curr = queue.peek();
        // pre.left = null;
        // pre.right = curr;
        // }

        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        TreeNode l = root.left;
        TreeNode r = root.right;

        root.left = null;
        root.right = l;

        while(l.right != null) {
            left = left.right;
        }

        left.right = right;
    }

    // private void fun1(TreeNode root) {
    // if (root == null)
    // return;
    // queue.add(root);

    // fun1(root.left);
    // fun1(root.right);
    // }
}
// @lc code=end
