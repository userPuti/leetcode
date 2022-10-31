#
# @lc app=leetcode.cn id=258 lang=python3
#
# [258] 各位相加
#


# @lc code=start
class Solution:

    def addDigits(self, num: int) -> int:

        def get_sum(num):
            total_sum = 0

            while num > 0:
                (num, x) = divmod(num, 10)
                total_sum += x
            
            return total_sum
        
        while num > 9:
            num = get_sum(num)
        
        return num

# @lc code=end
