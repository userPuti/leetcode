package 括号问题;

/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        // Stack<Character> left = new Stack<>();
        // Stack<Character> right = new Stack<>();

        // for(char c : s.toCharArray()) {
        // if(c == '(') {
        // left.push(c);
        // } else {
        // if(!left.isEmpty()) {
        // left.pop();
        // continue;
        // }
        // right.push(c);
        // }
        // }

        // return left.size()+right.size();

        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                right++;
            } else {
                right--;

                if(right == -1) {
                    right = 0;
                    left++;
                }
            }
        }

        return left+right;

    }
}
// @lc code=end
