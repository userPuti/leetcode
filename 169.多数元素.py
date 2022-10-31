#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 多数元素
#


# @lc code=start
class Solution:

    def majorityElement(self, nums: List[int]) -> int:

        # nums_set = set(nums)
        # dict = {}
        # ans = -1

        # for n in nums_set:
        #     dict[nums.count(n)] = n

        # k = len(nums)//2

        # for key in dict.keys():
        #     if key > k:
        #         ans = dict[key]

        # return ans

        target, count = 0, 0

        for n in nums:
            if count == 0:
                target = n
                count = 1
            elif n == target:
                count += 1
            else:
                count -= 1
        
        return target


# @lc code=end
