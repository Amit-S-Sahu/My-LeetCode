class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i = 0; i<dp.length;i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, m, n, dp);
    }

    static int helper(int row, int col, int m, int n, int[][] dp){
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];

        if(row == m - 1){
            return dp[row][col] = helper(row, col+1, m, n, dp);
        }else if(col == n - 1){
           return dp[row][col] = helper(row+1, col, m, n, dp);
        }

        return dp[row][col] = helper(row+1, col, m, n, dp) + helper(row, col+1, m, n, dp);
    }
}