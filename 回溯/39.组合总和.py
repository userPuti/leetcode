#
# @lc app=leetcode.cn id=39 lang=python3
#
# [39] 组合总和
#

# @lc code=start


class Solution:

    def combinationSum(self, candidates: List[int],
                       target: int) -> List[List[int]]:
        res = []
        track = []
        n = len(candidates)

        def dfs(index: int, sum: int) -> None:
            if sum > target:
                return

            if sum == target:
                res.append(track.copy())
                return

            for i in range(index, n):
                track.append(candidates[i])
                sum += candidates[i]
                dfs(i, sum)
                sum -= candidates[i]
                track.pop()

        dfs(0, 0)
        return res


# @lc code=end
