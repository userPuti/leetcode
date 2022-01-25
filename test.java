import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test {


    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};    
        int[] nums2 = {1,10,4,11};
        
        advantageCount(nums1, nums2);
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> map2 = new PriorityQueue<>(
                // (int[] pair1, int[] pair2) -> {
                //     return pair2[1] - pair1[1];
                // }
                    new Comparator<int[]>() {

                        @Override
                        public int compare(int[] o1, int[] o2) {
                            // TODO Auto-generated method stub
                            return o2[1]-o1[1];
                        }

                    }
                );

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
