#
# @lc app=leetcode.cn id=171 lang=python3
#
# [171] Excel 表列序号
#


# @lc code=start
class Solution:

    def titleToNumber(self, columnTitle: str) -> int:
        res, mul = 0, 0

        for i in range(len(columnTitle) - 1, -1, -1):
            k = ord(columnTitle[i]) - ord('A') + 1
            res += k * (26**mul)
            mul += 1

        return res
# @lc code=end
