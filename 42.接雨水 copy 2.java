import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int left_max = 0;
        int right_max = 0;

        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) {
                    ans += left_max - height[left];
                } else {
                    left_max = height[left];
                }
                left++;
            } else {
                if (height[right] < right_max) {
                    ans += right_max - height[right];
                } else {
                    right_max = height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
// @lc code=end
