package 单调栈;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];

        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < 2 * length - 1; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % length];
            }

            stack.push(i % length);
        }

        return res;
    }
}
// @lc code=end
