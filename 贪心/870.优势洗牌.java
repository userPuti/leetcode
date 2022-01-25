package 贪心;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> map2 = new PriorityQueue<>(
                (int[] pair1, int pair2[]) -> {
                    return pair2[1] - pair1[1];
                });

        for (int i = 0; i < nums2.length; i++) {
            map2.offer(new int[] { i, nums2[i] });
        }

        Arrays.sort(nums1);

        int low = 0;
        int high = nums1.length - 1;
        int[] res = new int[nums1.length];

        while (!map2.isEmpty()) {
            int[] pair = map2.poll();
            int cur = pair[0];
            int n2Max = pair[1];

            if (nums1[high] > n2Max) {
                res[cur] = nums1[high];
                high--;
            } else {
                res[cur] = nums1[low];
                low++;
            }
        }
        return res;
    }
}
// @lc code=end
