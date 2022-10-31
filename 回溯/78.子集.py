#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#


# @lc code=start


class Solution:

    def subsets(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []

        n = len(nums)
        res = []

        def backtrack(index: int, track: List[int]):
            res.append(track[:])

            for i in range(index, n):
                track.append(nums[i])
                backtrack(i+1, track)
                track.remove(nums[i])
        
        backtrack(0, [])
        return res


# @lc code=end
