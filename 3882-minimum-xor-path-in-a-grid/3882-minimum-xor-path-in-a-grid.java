class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> dp[][] = new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
                if (i == 0 && j == 0) dp[i][j].add(grid[i][j]);
                else {
                    if (i > 0) {
                        for (int num : dp[i - 1][j]) dp[i][j].add(num ^ grid[i][j]);
                    }
                    if (j > 0) {
                        for (int num : dp[i][j - 1]) dp[i][j].add(num ^ grid[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[m - 1][n - 1]) min = Math.min(min, num);
        return min;
    }
}