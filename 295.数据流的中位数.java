import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        // 默认的小顶堆
        large = new PriorityQueue<>();
        // 通过lambda函数实现一个大顶堆
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        if(small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        } else if (large.size() < small.size()) {
            return small.peek();
        } else {
            return (large.peek() + small.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end
