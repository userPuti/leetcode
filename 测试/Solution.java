package 测试;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

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