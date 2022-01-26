package 括号问题;
/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                right += 2;

                if (right % 2 == 1) {
                    left++;
                    right--;
                }
            } else {
                right--;

                if (right == -1) {
                    left++;
                    right = 1;
                }
            }
        }

        return left + right;
    }
}
// @lc code=end
