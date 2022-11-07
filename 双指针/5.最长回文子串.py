#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#


# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        len_s = len(s)

        def getPalindrome(left: int, right: int) -> str:
            while left >= 0 and right < len_s:
                if s[left] == s[right]:
                    left -= 1
                    right += 1
                else:
                    break
            return s[left + 1:right]

        res = ''
        for i in range(len_s):
            s1 = getPalindrome(i, i)
            s2 = getPalindrome(i, i + 1)

            res = res if len(res) > len(s1) else s1
            res = res if len(res) > len(s2) else s2

        return res

# @lc code=end
