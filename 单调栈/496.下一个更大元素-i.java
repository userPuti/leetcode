package 单调栈;
/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

import java.util.Stack;

// @lc code=start
class Solution {
    public int search(int[] nums, int k) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                res = i;
            }
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
         * int[] res = new int[nums1.length];
         * 
         * for (int i = 0; i < nums1.length; i++) {
         * int index = search(nums2, nums1[i]);
         * // System.out.println(index);
         * if (index == nums2.length - 1) {
         * res[i] = -1;
         * continue;
         * }
         * 
         * int j = 0;
         * 
         * for (j = index + 1; j < nums2.length; j++) {
         * if (nums2[j] > nums1[i]) {
         * res[i] = nums2[j];
         * break;
         * }
         * }
         * 
         * if (j == nums2.length) {
         * res[i] = -1;
         * }
         * }
         * 
         * return res;
         */

        int[] sta = new int[nums2.length];
        Stack<Integer> s = new Stack<>();

        for (int i = nums2.length-1; i >= 0; i--) {
            while (!s.isEmpty() && nums2[i] >= s.peek()) {
                s.pop();
            }

            sta[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums2[i]);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = search(nums2, nums1[i]);
            res[i] = sta[index];
        }

        return res;
    }
}
// @lc code=end
