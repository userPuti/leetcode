#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#


# @lc code=start
class Solution:

    def longestPalindrome(self, s: str) -> str:
        len_s = len(s)
        if len_s < 2:
            return s

        dp = [[False] * len_s for _ in range(len_s)]
        max_len = 1
        begin = 0

        for i in range(len_s):
            dp[i][i] = True

        for L in range(2, len_s + 1):
            for i in range(len_s):
                j = L + i - 1

                if j >= len_s:
                    break

                if s[i] != s[j]:
                    dp[i][j] = False
                else:
                    if j - i < 3:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]

                if dp[i][j] and j - i + 1 > max_len:
                    max_len = j - i + 1
                    begin = i

        return s[begin:begin + max_len]


# @lc code=end
