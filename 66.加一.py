#
# @lc app=leetcode.cn id=66 lang=python
#
# [66] 加一
#

# @lc code=start


class Solution(object):

    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        return [int(i) for i in str(int(''.join([str(j) for j in digits]))+1)]


# @lc code=end
