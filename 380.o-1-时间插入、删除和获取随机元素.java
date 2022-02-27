import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        map.put(list.get(list.size() - 1), index);
        list.set(index, list.get(list.size() - 1));

        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
