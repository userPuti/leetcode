package 单调队列;

import java.util.ArrayList;
import java.util.LinkedList;


/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    class MonotonicQueue {
        private LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int n) {
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                res.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }

        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
// @lc code=end
