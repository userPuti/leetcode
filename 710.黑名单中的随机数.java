import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=710 lang=java
 *
 * [710] 黑名单中的随机数
 */

// @lc code=start
class Solution {
    int division;
    Map<Integer, Integer> map = new HashMap();
    Random rand = new Random();

    public Solution(int n, int[] blacklist) {

        division = n - blacklist.length;

        for (int b : blacklist) {
            map.put(b, 666);
        }

        int last = n - 1;

        for (int b : blacklist) {
            if (b >= division) {
                continue;
            }

            while (map.containsKey(last)) {
                last--;
            }

            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        int index = rand.nextInt(division);

        if (map.containsKey(index)) {
            return map.get(index);
        }

        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
// @lc code=end
