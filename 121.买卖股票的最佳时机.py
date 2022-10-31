#
# @lc app=leetcode.cn id=121 lang=python
#
# [121] 买卖股票的最佳时机
#


# @lc code=start
class Solution(object):

    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """

        n = len(prices)
        dp = [[0 for i in range(2)]for j in range(n)]
    
        dp[0][1] = -prices[0]

        for i in range(1, n):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], -prices[i])

        return dp[n-1][0]


# @lc code=end
