#
# @lc app=leetcode.cn id=40 lang=python3
#
# [40] 组合总和 II
#


# @lc code=start
class Solution:

    def combinationSum2(self, candidates: List[int],
                        target: int) -> List[List[int]]:
        res = []
        track = []
        candidates = sorted(candidates)
        n = len(candidates)

        def trackback(index: int, sum: int) -> None:
            if sum == target:
                res.append(list(track))
                return

            if sum > target:
                return

            for i in range(index, n):
                if i > index and candidates[i] == candidates[i-1]:
                    continue

                track.append(candidates[i])
                sum += candidates[i]
                trackback(i + 1, sum)
                sum -= candidates[i]
                track.remove(candidates[i])

        trackback(0, 0)
        return res

# @lc code=end
