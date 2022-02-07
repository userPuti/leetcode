import java.util.HashMap;
import java.util.LinkedHashSet;

/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start
class LFUCache {
    HashMap<Integer, Integer> kv;
    HashMap<Integer, Integer> kf;
    HashMap<Integer, LinkedHashSet<Integer>> fk;

    int minFreq;
    int cap;

    public LFUCache(int capacity) {
        kv = new HashMap<>();
        kf = new HashMap<>();
        fk = new HashMap<>();

        this.minFreq = 0;
        this.cap = capacity;
    }

    public int get(int key) {
        if (!kv.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);
        return kv.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }

        if (kv.containsKey(key)) {
            kv.put(key, value);
            increaseFreq(key);
            return;
        }

        if (this.cap <= kv.size()) {
            removeMinFreq(key);
        }

        kv.put(key, value);
        kf.put(key, 1);
        fk.putIfAbsent(1, new LinkedHashSet<>());
        fk.get(1).add(key);
        this.minFreq = 1;
    }

    private void removeMinFreq(int key) {
        LinkedHashSet<Integer> keyList = fk.get(this.minFreq);
        int deleteKey = keyList.iterator().next();

        keyList.remove(deleteKey);

        if (keyList.isEmpty()) {
            fk.remove(this.minFreq);
        }

        kv.remove(deleteKey);
        kf.remove(deleteKey);
    }

    private void increaseFreq(int key) {
        int freq = kf.get(key);
        kf.put(key, freq + 1);

        fk.get(freq).remove(key);
        fk.putIfAbsent(freq + 1, new LinkedHashSet<>());
        fk.get(freq + 1).add(key);

        if (fk.get(freq).isEmpty()) {
            fk.remove(freq);

            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
