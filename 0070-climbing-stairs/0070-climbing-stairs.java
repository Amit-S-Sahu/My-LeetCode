class Solution {
    private int helper(int dp[], int n) {
        if (dp[n] != -1) return dp[n];
        dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
        return dp[n];
    }
    
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        return helper(dp, n);
    }
}