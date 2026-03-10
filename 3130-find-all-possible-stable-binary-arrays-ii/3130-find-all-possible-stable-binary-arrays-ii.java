class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long mod = (long)(1e9 + 7);
        long dp[][][] = new long[2][zero + 1][one + 1];
        for (int i = 0; i <= Math.min(zero, limit); i++) dp[0][i][0] = 1;
        for (int i = 0; i <= Math.min(one, limit); i++) dp[1][0][i] = 1;
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                if (i > limit) dp[0][i][j] = dp[0][i - 1][j] + dp[1][i - 1][j] - dp[1][i - limit - 1][j];
                else dp[0][i][j] = dp[0][i - 1][j] + dp[1][i - 1][j];
                dp[0][i][j] = ((dp[0][i][j] % mod) + mod) % mod;
                if (j > limit) dp[1][i][j] = dp[1][i][j - 1] + dp[0][i][j - 1]  - dp[0][i][j - limit - 1];
                else dp[1][i][j] = dp[1][i][j - 1] + dp[0][i][j - 1];
                dp[1][i][j] = ((dp[1][i][j] % mod) + mod) % mod;
            }
        }
        return (int)((dp[0][zero][one] + dp[1][zero][one]) % mod);
    }
}