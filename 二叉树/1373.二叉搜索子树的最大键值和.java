package 二叉树;

/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
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
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] { 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];

        if (left[0] == 1 && right[0] == 1 && root.val < right[1] && root.val > left[2]) {
            res[0] = 1;

            res[1] = Math.min(left[1],root.val);
            res[2] = Math.max(right[2],root.val);
            res[3] = left[3]+right[3]+root.val;

            maxSum = Math.max(maxSum,res[3]);
        } else {
            res[0] = 0;
        }

        return res;
    }
}
// @lc code=end
