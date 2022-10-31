#
# @lc app=leetcode.cn id=69 lang=python
#
# [69] x 的平方根
#


# @lc code=start
class Solution(object):

    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """

        l, r, ans = 0, x, -1
        while l <= r:
            mid = l + (r - l) // 2

            if mid * mid <= x:
                ans = mid
                l = mid + 1
            elif mid * mid > x:
                r = mid - 1
            
        return ans
# @lc code=end
