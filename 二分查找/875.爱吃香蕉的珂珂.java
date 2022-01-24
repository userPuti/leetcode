package 二分查找;
/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = (int) Math.pow(10, 9);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (fun(piles, mid) == h) {
                high = mid - 1;
            } else if (fun(piles, mid) < h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        
        return low;
    }

    public int fun(int[] piles, int k) {
        int hours = 0;

        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / k;
            if (piles[i] % k > 0) {
                hours++;
            }
        }
        return hours;
    }
}
// @lc code=end
