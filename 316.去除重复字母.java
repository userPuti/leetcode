import java.util.Stack;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            count[c]--;

            //保证不重复
            if (inStack[c] == true) { 
                continue;
            }


            while (!stk.isEmpty() && stk.peek() > c) {
                //如果栈顶的元素是字符串中唯一的一个，那就不能出栈
                if (count[stk.peek()] == 0) {
                    break;
                } else {
                    inStack[stk.pop()] = false;
                }
            }

            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();

    }
}
// @lc code=end
