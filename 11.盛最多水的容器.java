/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int cur_max = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);

            if (area > cur_max) {
                cur_max = area;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return cur_max;
    }
}
// @lc code=end

