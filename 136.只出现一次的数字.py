#
# @lc app=leetcode.cn id=136 lang=python
#
# [136] 只出现一次的数字
#

# @lc code=start
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        x = nums[0]

        for i in range(1, len(nums)):
            x = x ^ nums[i]

        return x
# @lc code=end

