package 滑动数组;
/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

import java.util.HashMap;

// @lc code=start
class Solution {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> needs = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();

        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;

        for (char t1 : t.toCharArray()) {
            needs.put(t1, needs.getOrDefault(t1, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            while (valid == needs.size()) {
                // 注意在left++之前保留一个可能正确的位置，否则left的位置就会往前移动一个，造成不必要的麻烦
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (needs.containsKey(d)) {
                    if (needs.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
// @lc code=end
