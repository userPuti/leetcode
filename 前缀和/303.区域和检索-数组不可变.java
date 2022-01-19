package 前缀和;

/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    private int[] preNum;
 
    public NumArray(int[] nums) {
        preNum = new int[nums.length+1];

        for(int i = 1; i <= nums.length; i++ ) {
            preNum[i] = preNum[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return preNum[right+1] - preNum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

