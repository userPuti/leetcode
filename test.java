import javax.sound.sampled.SourceDataLine;

public class test {


    public static void main(String[] args) {
      int[] weight = {1,2,3,4,5,6,7,8,9,10};
      int days = 5;
    //   System.out.println(fun(weight,days));
      System.out.println(shipWithinDays(weight, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right = right + w;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (fun(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int fun(int[] weights, int x) {
        int days = 0;

        int i = 0;
        while (i < weights.length) {
            int cap = x;

            while (i < weights.length) {
                if(cap < weights[i]) break;
                else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }
}
