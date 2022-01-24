package 二分查找;

/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right = right + w;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (fun(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int fun(int[] weights, int x) {
        int days = 0;

        int i = 0;
        while (i < weights.length) {
            int cap = x;

            while (i < weights.length) {
                if (cap < weights[i])
                    break;
                else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }
}
// @lc code=end
