class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            dp[i] = 1;
            while (j >= 0) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                j--;
            }
            ans = Math.max(ans, dp[i]);

        }
        return ans;
    }
}