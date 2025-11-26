class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = (int) 1e9 + 7;
        int m = grid.length;
        int n = grid[0].length;
        
        int dp[][][] = new int[m][n][k];
        
        int firstRemainder = grid[0][0] % k;
        dp[0][0][firstRemainder] = 1;
        
        for (int j = 1; j < n; j++) {
            int currentRem = grid[0][j] % k;
            for (int r = 0; r < k; r++) {
                if (dp[0][j-1][r] > 0) {
                    int newRem = (r + currentRem) % k;
                    dp[0][j][newRem] = (dp[0][j][newRem] + dp[0][j-1][r]) % MOD;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            int currentRem = grid[i][0] % k;
            for (int r = 0; r < k; r++) {
                if (dp[i-1][0][r] > 0) {
                    int newRem = (r + currentRem) % k;
                    dp[i][0][newRem] = (dp[i][0][newRem] + dp[i-1][0][r]) % MOD;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int currentRem = grid[i][j] % k;
                
                for (int r = 0; r < k; r++) {
                    if (dp[i-1][j][r] > 0) {
                        int newRem = (r + currentRem) % k;
                        dp[i][j][newRem] = (dp[i][j][newRem] + dp[i-1][j][r]) % MOD;
                    }
                }
                
                for (int r = 0; r < k; r++) {
                    if (dp[i][j-1][r] > 0) {
                        int newRem = (r + currentRem) % k;
                        dp[i][j][newRem] = (dp[i][j][newRem] + dp[i][j-1][r]) % MOD;
                    }
                }
            }
        }
        
        return dp[m - 1][n - 1][0];
    }
}