#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#


# @lc code=start
class Solution:

    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []

        def trackback(index: int, track: List[int], k: int) -> None:
            if len(track) == k:
                res.append(track[:])
                return

            for i in range(index, n + 1):
                track.append(i)
                trackback(i + 1, track, k)
                track.remove(i)

        trackback(1, [], k)
        return res

# @lc code=end
