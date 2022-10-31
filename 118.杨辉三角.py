#
# @lc app=leetcode.cn id=118 lang=python
#
# [118] 杨辉三角
#


# @lc code=start
class Solution(object):

    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """

        ret = list()

        for i in range(numRows):
            row = list()

            for j in range(0, i + 1):
                if j == 0 or j == i:
                    row.append(1)
                else:
                    row.append(ret[i - 1][j - 1] + ret[i - 1][j])

            ret.append(row)

        return ret


# @lc code=end
