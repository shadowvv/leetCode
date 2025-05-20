package other;

import java.util.HashSet;
import java.util.Set;

public class Q3342_2 {

    public int minTimeToReach(int[][] moveTime) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int n = moveTime.length;
        int m = moveTime[0].length;

        int maxTime = 0;
        int topIndex = 0;
        int leftIndex = 0;
        int from = 0;
        int period = 1;
        while (true) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            int top = Integer.MAX_VALUE;
            int bottom = Integer.MAX_VALUE;

            if (from != 1 && topIndex - 1 >= 0) {
                top = Math.max(maxTime, moveTime[topIndex - 1][leftIndex]) + period;
            }
            if (from != 2 && leftIndex - 1 >= 0) {
                left = Math.max(maxTime, moveTime[topIndex][leftIndex - 1]) + period;
            }
            if (from != 3 && topIndex + 1 < n) {
                bottom = Math.max(maxTime, moveTime[topIndex + 1][leftIndex]) + period;
            }
            if (from != 4 && leftIndex + 1 < m) {
                right = Math.max(maxTime, moveTime[topIndex][leftIndex + 1]) + period;
            }

            while (true) {
                maxTime = Math.min(Math.min(left, right), Math.min(top, bottom));
                if (maxTime == bottom) {
                    if (set.contains((topIndex + 1) + "," + leftIndex)) {
                        bottom = Integer.MAX_VALUE;
                    } else {
                        from = 1;
                        topIndex++;
                        set.add(topIndex + "," + leftIndex);
                        break;
                    }
                } else if (maxTime == right) {
                    if (set.contains(topIndex + "," + (leftIndex + 1))) {
                        right = Integer.MAX_VALUE;
                    } else {
                        from = 2;
                        leftIndex++;
                        set.add(topIndex + "," + leftIndex);
                        break;
                    }
                } else if (maxTime == top) {
                    if (set.contains((topIndex - 1) + "," + leftIndex)) {
                        top = Integer.MAX_VALUE;
                    } else {
                        from = 3;
                        topIndex--;
                        set.add(topIndex + "," + leftIndex);
                        break;
                    }
                } else if (maxTime == left) {
                    if (set.contains(topIndex + "," + (leftIndex - 1))) {
                        left = Integer.MAX_VALUE;
                    } else {
                        from = 4;
                        leftIndex--;
                        set.add(topIndex + "," + leftIndex);
                        break;
                    }
                }
            }
            period = (period + 1) % 2 == 0 ? 2 : 1;
            System.out.println("topIndex = " + topIndex + ", leftIndex = " + leftIndex + ", maxTime = " + maxTime);
            if (topIndex == n - 1 && leftIndex == m - 1) {
                return maxTime;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q3342_2().minTimeToReach(new int[][] { { 4, 13, 67 }, { 20, 24, 57 } })); // 7
    }

}
