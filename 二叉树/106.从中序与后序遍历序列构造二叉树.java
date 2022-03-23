package 二叉树;
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inOrder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }

        int rootVal = postorder[postend];
        int index = -1;

        for (int i = instart; i <= inend; i++) {
            if (inOrder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(rootVal);

        int leftSize = index - instart;
        node.left = build(inOrder, instart, index - 1, postorder, poststart, poststart + leftSize - 1);
        node.right = build(inOrder, index + 1, inend, postorder, poststart + leftSize, postend - 1);
        return node;
    }
}
// @lc code=end
