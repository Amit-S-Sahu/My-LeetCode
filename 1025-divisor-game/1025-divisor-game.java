class Solution {
    public boolean divisorGame(int n) {
        boolean dp[] = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j < n; j++) {
                if (i % j == 0) dp[i] = dp[i] | !dp[i - j];
            }
        }
        return dp[n];
    }
}