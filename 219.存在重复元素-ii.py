#
# @lc app=leetcode.cn id=219 lang=python3
#
# [219] 存在重复元素 II
#


# @lc code=start
class Solution:

    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        sort_list = sorted(enumerate(nums, 0), key=lambda x: x[1])

        for i in range(0, len(sort_list) - 1):
            j = i + 1
            if sort_list[i][1] == sort_list[j][1] and abs(
                    sort_list[i][0] - sort_list[j][0]) <= k:
                return True

        return False


# @lc code=end
