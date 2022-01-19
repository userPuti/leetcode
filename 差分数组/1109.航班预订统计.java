package 差分数组;
/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    class Difference {
        private int[] diff;
    
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            diff[0] = nums[0];
    
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }
    
        public void increment(int left, int right, int val) {
            diff[left] += val;
            if (right + 1 < diff.length) {
                diff[right + 1] -= val;
            }
        }
    
        public int[] result(){
            int[] res = new int[diff.length];
    
            res[0] = diff[0];
    
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
    


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference diff = new Difference(nums);

        for (int i = 0; i < bookings.length; i++) {
            int left = bookings[i][0] - 1;
            int right = bookings[i][1] - 1;
            int val = bookings[i][2];

            diff.increment(left, right, val);
        }
        return diff.result();
    }
}
// @lc code=end
