#
# @lc app=leetcode.cn id=228 lang=python3
#
# [228] 汇总区间
#


# @lc code=start
class Solution:

    def summaryRanges(self, nums: List[int]) -> List[str]:
        i, j = 0, 0
        ans = list()
        len_nums = len(nums)
        
        while i < len_nums:
            j = i + 1
            count = 1

            while j < len_nums:
                if nums[j] == nums[i] + count:
                    j += 1
                    count += 1
                else:
                    break
                    
            if j != i+1:
                ans.append("{0}->{1}".format(nums[i], nums[j-1]))
            else:
                ans.append("{0}".format(nums[i]))

            i = j

        return ans

    # @lc code=end
