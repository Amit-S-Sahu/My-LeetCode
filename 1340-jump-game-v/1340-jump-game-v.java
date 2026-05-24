class Solution {
    private int dp[];

    private void dfs(int arr[], int id, int d, int n) {
        if (dp[id] != -1) return;
        dp[id] = 1;
        for (int i = id - 1; i >= 0 && id - i <= d && arr[id] > arr[i]; --i) {
            dfs(arr, i, d, n);
            dp[id] = Math.max(dp[id], dp[i] + 1);
        }
        for (int i = id + 1; i < n && i - id <= d && arr[id] > arr[i]; ++i) {
            dfs(arr, i, d, n);
            dp[id] = Math.max(dp[id], dp[i] + 1);
        }
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; ++i) {
            dfs(arr, i, d, n);
        }
        int ans = 0;
        for (int val : dp) {
            ans = Math.max(ans, val);
        }
        return ans;
    }
}