#
# @lc app=leetcode.cn id=27 lang=python3
#
# [27] 移除元素
#

# @lc code=start
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        idx, p = 0, 0

        while p < len(nums):
            if nums[p] != val:
                nums[idx] = nums[p]
                idx += 1
            p += 1
        return idx
# @lc code=end

