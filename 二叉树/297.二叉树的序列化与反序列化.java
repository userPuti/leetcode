package 二叉树;
import java.util.List;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String SEP = ",";
    String _NULL = "#";

    StringBuilder sb = new StringBuilder();
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(_NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);

        serialize(root.left,sb);
        serialize(root.right,sb);
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList<String>();
        for(String node : data.split(SEP)) {
            nodes.add(node);
            // System.out.println(node);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(List<String> nodes) {
        if(nodes == null || nodes.size() == 0) {
            return null;
        }

        String node =  nodes.get(0);
        nodes.remove(0);
        // System.out.println(node);
        if(node.equals(_NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));
        
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

