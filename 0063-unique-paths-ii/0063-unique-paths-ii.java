class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < m; i++) {
            if (dp[i][0] == Integer.MAX_VALUE) continue;
            dp[i][0] = dp[i - 1][0] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1;
        }

        for (int i = 1; i < n; i++) {
            if (dp[0][i] == Integer.MAX_VALUE) continue;
            dp[0][i] = dp[0][i - 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                dp[i][j] = (dp[i - 1][j] == Integer.MAX_VALUE ? 0 : dp[i - 1][j]) + (dp[i][j - 1] == Integer.MAX_VALUE ? 0 : dp[i][j - 1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? 0 : dp[m - 1][n - 1];
    }
}