package 滑动数组;
/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

import java.util.HashMap;

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == needs.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;

                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
// @lc code=end
