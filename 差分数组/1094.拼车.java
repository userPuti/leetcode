package 差分数组;
/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {

    public int[] getDiff(int[] nums) {
        int len = nums.length;
        int[] diff = new int[len];

        diff[0] = nums[0];

        for (int i = 1; i <= len; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        return diff;
    }

    public void increment(int[] diff, int left, int right, int val) {
        diff[left] += val;
        if (right + 1 < diff.length) {
            diff[right + 1] -= val;
        }
    }

    public int[] result(int[] diff) {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for (int i = 0; i < trips.length; i++) {
            int left = trips[i][1];
            int right = trips[i][2] - 1;
            int val = trips[i][0];
            increment(diff, left, right, val);
        }

        diff = result(diff);
        for (int i = 0; i < diff.length; i++) {
            if(diff[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
