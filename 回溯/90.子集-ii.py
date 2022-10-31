#
# @lc app=leetcode.cn id=90 lang=python3
#
# [90] 子集 II
#

# @lc code=start
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        track = []
        nums = sorted(nums)
        n = len(nums)

        def trackback(index: int) -> None:
            res.append(list(track))

            for i in range(index, n):
                if i > index and nums[i] == nums[i-1]:
                    continue
                    
                track.append(nums[i])
                trackback(i+1)
                track.remove(nums[i])
        
        trackback(0)
        return res

# @lc code=end

