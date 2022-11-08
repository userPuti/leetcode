#
# @lc app=leetcode.cn id=322 lang=python3
#
# [322] 零钱兑换
#

# @lc code=start
import functools


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        @functools.cache
        def helper(amount):
            if amount == 0:
                return 0

            if amount < 0:
                return -1

            res = float('inf')
            for coin in coins:
                subpro = helper(amount - coin)
                if subpro == -1:
                    continue
                res = min(res, subpro + 1)
            return res if res != float('inf') else -1

        return helper(amount)


# @lc code=end
