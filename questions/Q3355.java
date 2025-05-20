package questions;

public class Q3355 {
    
    public boolean isZeroArray(int[] nums, int[][] queries) {
        if (nums == null || nums.length == 0 || queries == null || queries.length == 0) {
            return false;
        }

        int[] differ = new int[nums.length+1];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            differ[left]++;
            differ[right + 1]--;
        }
        for(int i = 0,sum = 0;i<nums.length;i++){
            sum += differ[i];
            if (nums[i] > sum) {
                return false;
            }
        }
        return true;
    }

}
