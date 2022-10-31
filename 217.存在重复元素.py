#
# @lc app=leetcode.cn id=217 lang=python3
#
# [217] 存在重复元素
#


# @lc code=start
class Solution:

    def containsDuplicate(self, nums: List[int]) -> bool:
        nums_dict = {}

        for num in nums:
            if nums_dict.get(num) is None:
                nums_dict[num] = 1
            else:
                return True

        return False

        

# @lc code=end
