class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left += nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - right);
            right += nums[i];
        }

        return ans;
    }
}