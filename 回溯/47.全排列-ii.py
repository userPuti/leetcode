#
# @lc app=leetcode.cn id=47 lang=python3
#
# [47] 全排列 II
#

# @lc code=start


class Solution:

    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        track = []
        n = len(nums)
        used = [False] * n
        nums.sort()

        def backtrack():
            if len(track) == n:
                res.append(list(track))
                return

            for i in range(n):
                if used[i]:
                    continue

                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue

                track.append(nums[i])
                used[i] = True
                backtrack()
                used[i] = False
                track.pop()

        backtrack()
        return res


# @lc code=end