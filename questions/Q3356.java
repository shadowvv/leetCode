package questions;

public class Q3356 {

    public int minZeroArray(int[] nums, int[][] queries) {
        if (nums == null || nums.length == 0 || queries == null || queries.length == 0) {
            return -1;
        }
        int[] differ = new int[nums.length + 1];

        int maxIndex = 0;
        int currentValue = 0;
        for (int i = 0; i < nums.length; i++) {
            currentValue += differ[i];
            while (maxIndex < queries.length && currentValue < nums[i]) {
                int left = queries[maxIndex][0];
                int right = queries[maxIndex][1];
                differ[left] += queries[maxIndex][2];
                differ[right + 1] -= queries[maxIndex][2];
                if (left <= i && i <= right) {
                    currentValue += queries[maxIndex][2];
                }
                maxIndex++;
            }
            if (currentValue < nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }
}
