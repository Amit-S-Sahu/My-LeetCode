class Solution {
    int dp[];
    private int helper(int n) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = helper(n - 1) + helper(n - 2);
        return dp[n];
    }

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n);
    }
}