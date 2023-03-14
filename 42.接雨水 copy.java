import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int ans = 0;

        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                ans += (Math.min(height[i], height[stack.peek()])-height[index]) * (i - stack.peek() - 1);
            }
            stack.push(i++);
        }
        return ans;
    }
}
// @lc code=end
