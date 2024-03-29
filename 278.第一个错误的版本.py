#
# @lc app=leetcode.cn id=278 lang=python3
#
# [278] 第一个错误的版本
#

# @lc code=start
# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:


class Solution:

    def firstBadVersion(self, n: int) -> int:
        lo, hi = 1, n

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if isBadVersion(mid):
                hi = mid - 1
            else:
                lo = mid + 1

        return lo


# @lc code=end
