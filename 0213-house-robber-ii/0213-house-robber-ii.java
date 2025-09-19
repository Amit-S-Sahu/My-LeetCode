class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(getMax(nums, 0, n - 2), getMax(nums, 1, n - 1));
    }

    private int getMax(int nums[], int start, int end) {
        int len = end - start + 1;
        int dp[] = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 1; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[start + i]);
        }
        return dp[len];
    }
}
