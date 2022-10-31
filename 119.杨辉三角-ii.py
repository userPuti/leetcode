#
# @lc app=leetcode.cn id=119 lang=python
#
# [119] 杨辉三角 II
#


# @lc code=start
class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        ret = [0] * (rowIndex + 1)
        ret[0] = 1
        for i in range(rowIndex + 1):
            for j in range(i, 0, -1):
                ret[j] += ret[j - 1]

        return ret


# @lc code=end
