package 前缀和;

import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);

        int sum0_i = 0;
        int sum0_j = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            sum0_j = sum0_i - k;

            if (preSum.containsKey(sum0_j)) {
                res += preSum.get(sum0_j);
            }

            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
// @lc code=end
