#
# @lc app=leetcode.cn id=290 lang=python3
#
# [290] 单词规律
#

# @lc code=start


class Solution:

    def wordPattern(self, pattern: str, s: str) -> bool:
        p_dict = {}
        s_dict = {}
        s_list = s.split()

        if len(pattern) != len(s_list):
            return False

        for i in range(len(pattern)):
            if p_dict.get(pattern[i]) is None and s_dict.get(s_list[i]) is None:
                p_dict[pattern[i]] = s_list[i]
                s_dict[s_list[i]] = pattern[i]

            elif p_dict.get(pattern[i]) != s_list[i] or s_dict.get(
                    s_list[i]) != pattern[i]:
                return False

        return True


# @lc code=end
