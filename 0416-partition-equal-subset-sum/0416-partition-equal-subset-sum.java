class Solution {
    private boolean helper(int nums[], Boolean dp[][], int n, int sum) {
        if (sum == 0) return true;
        if (n <= 0) return false;
        if (dp[n][sum] != null) return dp[n][sum];

        if (nums[n - 1] <= sum) {
            dp[n][sum] = helper(nums, dp, n - 1, sum) || helper(nums, dp, n - 1, sum - nums[n - 1]);
        }
        else dp[n][sum] = helper(nums, dp, n - 1, sum);

        return dp[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        sum /= 2;
        Boolean dp[][] = new Boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        for (int i = 1; i <= sum; i++) dp[0][i] = false;
        
        return helper(nums, dp, n, sum);
    }
}