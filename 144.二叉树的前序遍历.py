#
# @lc app=leetcode.cn id=144 lang=python
#
# [144] 二叉树的前序遍历
#


# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    res = []

    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        res = []

        def traverse(root):
            if root is None:
                return

            res.append(root.val)
            traverse(root.left)
            traverse(root.right)

        traverse(root)

        return res

# @lc code=end
