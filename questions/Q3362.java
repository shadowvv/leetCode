package questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q3362 {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] differ = new int[nums.length+1];
        int value = 0;
        for (int i = 0,j = 0; i < nums.length; i++) {
            value += differ[i];
            for (; j < queries.length; ) {
                if (queries[j][0] == i) {
                    pq.add(queries[j][1]);
                    j++;
                }else {
                    break;
                }
            }
            while (!pq.isEmpty()) {
                int right = pq.poll();
                differ[right+1]--;
                value++;
                if (value == nums[i]) {
                    break;
                }
            }
            if (value < nums[i]) {
                return -1;
            }
        }

        return pq.size();
    }
}
