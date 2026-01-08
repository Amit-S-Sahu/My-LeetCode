class Solution {
    int dp[];
    private int helper(int cost[], int n) {
        if (dp[n] != -1) return dp[n];
        dp[n] = Math.min(helper(cost, n - 1) + cost[n - 1], helper(cost, n - 2) + cost[n - 2]);
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 0;
        return helper(cost, n);
    }
}