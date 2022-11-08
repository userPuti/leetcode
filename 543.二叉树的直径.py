#
# @lc app=leetcode.cn id=543 lang=python3
#
# [543] 二叉树的直径
#


# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def getMaxDepth(root) -> int:
            if not root:
                return 0

            left = getMaxDepth(root.left)
            right = getMaxDepth(root.right)

            return max(left, right) + 1

        res = 0

        def traverse(root):
            if not root:
                return 0

            left = getMaxDepth(root.left)
            right = getMaxDepth(root.right)
            maxD = left + right
            # nonlocal res
            res = max(maxD, res)

            traverse(root.left)
            traverse(root.right)

        traverse(root)

        return res


# @lc code=end
