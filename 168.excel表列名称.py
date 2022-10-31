#
# @lc app=leetcode.cn id=168 lang=python
#
# [168] Excel表列名称
#


# @lc code=start
class Solution(object):

    def convertToTitle(self, columnNumber):
        """
        :type columnNumber: int
        :rtype: str
        """
        res = ''
        while columnNumber > 0:
            a0 = (columnNumber - 1) % 26 + 1
            res += chr(a0 - 1 + ord('A'))
            columnNumber = (columnNumber - a0) // 26

        return res[::-1]


# @lc code=end
