class Solution {
    int dp[];
    private int helper(int n) {
        if (dp[n] != -1) return dp[n];
        dp[n] = helper(n - 1) + helper(n - 2);
        return dp[n];
    }
    public int climbStairs(int n) {
        if (n < 3) return n;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 2;
        return helper(n);
    }
}