package 二叉树;
/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildMaximumBinaryTree(0, nums.length - 1, nums);
    }

    private TreeNode buildMaximumBinaryTree(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }

        int index = findMax(left, right, nums);

        TreeNode node = new TreeNode(nums[index]);

        node.left = buildMaximumBinaryTree(left, index - 1, nums);
        node.right = buildMaximumBinaryTree(index + 1, right, nums);

        return node;
    }

    private int findMax(int left, int right, int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }

        return index;
    }
}
// @lc code=end
