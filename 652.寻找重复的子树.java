import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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

    private HashMap<String, Integer> map = new HashMap<String, Integer>();

    private List<TreeNode> res = new ArrayList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {

        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "." + right + "." + root.val;

        int count = map.getOrDefault(subTree, 0);

        if (count == 1) {
            res.add(root);
        }

        map.put(subTree, count + 1);

        return subTree;
    }
}
// @lc code=end
