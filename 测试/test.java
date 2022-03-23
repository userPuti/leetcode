package 测试;

public class test {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);

        a.left = b;
        a.right = c;
        c.left = e;
        c.right = f;
        b.left = d;
        e.left = g;

        for (TreeNode node : new Solution().findDuplicateSubtrees(a)) {
            System.out.println(node.val);
        }
    }

}
