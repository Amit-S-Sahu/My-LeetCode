class Solution {
    int dp[];
    private int helper(int nums[], int n) {
        if(dp[n] != -1) return dp[n];
        dp[n] = Math.max(helper(nums, n - 2) + nums[n - 1], helper(nums, n - 1));
        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];
        dp = new int[n + 1];
        Arrays.fill(dp, - 1);
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, n), helper(nums, n - 1));
    }
}