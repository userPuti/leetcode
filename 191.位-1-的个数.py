#
# @lc app=leetcode.cn id=191 lang=python3
#
# [191] 位1的个数
#

# @lc code=start
class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        for i in range(32):
            temp = (n & 1)
            if temp == 1:
                ans += 1
            n >>= 1
        return ans
# @lc code=end

