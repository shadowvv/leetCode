package other;

public class Q3342 {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dp = new int[n][m];

        int maxIndex = Math.max(n, m);
        for (int index = 1; index <= maxIndex; index++) {
            if (index == 1) {
                dp[0][0] = 0;
                continue;
            }

            int leftIndex = Math.min(n, index);
            int rightIndex = Math.min(m, index);

            for (int i = 0; i < leftIndex - 1; i++) {
                int left = Integer.MAX_VALUE;
                int top = Integer.MAX_VALUE;
                if (i > 0) {
                    top = dp[i - 1][rightIndex - 1];
                }
                if (rightIndex - 1 > 0) {
                    left = dp[i][rightIndex - 2];
                }
                int min = Math.min(left, top);
                int indexSum = i + rightIndex - 1;
                int period = indexSum%2 == 0 ? 2 : 1;
                int maxValue = Math.max(min, moveTime[i][rightIndex - 1]) + period;
                System.out.println("first dp[" + i + "][" + (rightIndex - 1) + "] : moveTime = " + moveTime[i][rightIndex - 1]);
                dp[i][rightIndex - 1] = maxValue;
            }

            for (int j = 0; j < rightIndex; j++) {
                int left = Integer.MAX_VALUE;
                int top = Integer.MAX_VALUE;
                if (leftIndex - 1 > 0) {
                    top = dp[leftIndex - 2][j];
                }
                if (j > 0) {
                    left = dp[leftIndex - 1][j - 1];
                }
                int min = Math.min(left, top);
                int indexSum = j + leftIndex - 1;
                int period = indexSum%2 == 0 ? 2 : 1;
                int maxValue = Math.max(min, moveTime[leftIndex - 1][j]) + period;
                System.out.println("second dp[" + (leftIndex - 1) + "][" + j + "] : moveTime = " + moveTime[leftIndex - 1][j]);
                dp[leftIndex - 1][j] = maxValue;
            }

        }
        //打印dp数组的图像
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n - 1][m - 1];
    }

    // public static void main(String[] args) {
    //     System.out.println(new Q3342().minTimeToReach(new int[][] { { 38,87,68,34,32,8}, { 3,29,39,73,86,10} })); // 7
    // }

}
