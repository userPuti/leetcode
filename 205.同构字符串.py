#
# @lc app=leetcode.cn id=205 lang=python3
#
# [205] 同构字符串
#


# @lc code=start
class Solution:

    def isIsomorphic(self, s: str, t: str) -> bool:
        s_dict = {}
        t_dict = {}

        for i in range(len(s)):
            x = s[i]
            y = t[i]
            if (s_dict.get(x) and s_dict[x] != y) or (t_dict.get(y)
                                                      and t_dict[y] != x):
                return False
            s_dict[x] = y
            t_dict[y] = x
            
        return True


# @lc code=end
