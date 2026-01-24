class Solution {
    int helper(int dp[], int nums[], int n) {
        if (dp[n] != -1) return dp[n];
        dp[n] = Math.max(helper(dp, nums, n - 1), nums[n - 1] + helper(dp, nums, n - 2));
        return dp[n];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        if (n == 1) return dp[1];
        dp[2] = Math.max(nums[0], nums[1]);
        if (n == 2) return dp[2];
        return helper(dp, nums, n);
    }
}