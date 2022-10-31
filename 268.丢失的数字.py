#
# @lc app=leetcode.cn id=268 lang=python3
#
# [268] 丢失的数字
#


# @lc code=start
class Solution:

    def missingNumber(self, nums: List[int]) -> int:
        len_nums = len(nums)
        
        res = 0
        res ^= len_nums

        for i in range(0, len_nums):
            res ^= i ^ nums[i]

        return res


# @lc code=end
