#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_dict = {}
        for x in s:
            if s_dict.get(x) is None:
                s_dict[x] = 1
            else:
                s_dict[x] += 1
        
        t_dict = {}
        for y in t:
            if t_dict.get(y) is None:
                t_dict[y] = 1
            else:
                t_dict[y] += 1
        
        return s_dict == t_dict
# @lc code=end

