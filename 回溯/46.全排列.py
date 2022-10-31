#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#

# @lc code=start


class Solution:

    def permute(self, nums: List[int]) -> List[List[int]]:
        res = list()

        def backtrack(nums: List[int], tmp: List[int]):
            if not nums:
                res.append(list(tmp))
                return

            for i in range(len(nums)):
                tmp.append(nums[i])
                backtrack(nums[:i] + nums[i + 1:], tmp)
                tmp.remove(nums[i])

        backtrack(nums, [])

        return res


# @lc code=end
