package 二叉树;
/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int prestart, int preend, int[] postorder, int poststart, int postend) {
        if (prestart > preend) {
            return null;
        }

        if(poststart == postend) {
            return new TreeNode(preorder[prestart]);
        }

        int rootVal = preorder[prestart];
        int leftRoot = preorder[prestart + 1];
        int index = -1;

        for (int i = poststart; i < postend; i++) {
            if (postorder[i] == leftRoot) {
                index = i;
                break;
            }
        }

        int leftsize = index - poststart + 1;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, prestart + 1, prestart + leftsize, postorder, poststart, index);
        root.right = build(preorder, prestart + leftsize + 1, preend, postorder, index + 1, postend - 1);

        return root;
    }
}
// @lc code=end
