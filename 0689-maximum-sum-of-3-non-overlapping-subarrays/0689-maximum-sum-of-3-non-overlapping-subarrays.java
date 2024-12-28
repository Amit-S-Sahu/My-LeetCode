class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < k * 3) return new int[] {};

        int n = nums.length - k + 1;

        int subSum[] = new int[n];
        int sum = 0;

        for (int i = 0; i < k; i++) sum += nums[i];

        subSum[0] = sum;

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            subSum[i - k + 1] = sum;
        }

        int maxLeft[] = new int[n];

        for (int i = 1; i < n; i++) maxLeft[i] = (subSum[i] > subSum[maxLeft[i - 1]]) ? i : maxLeft[i - 1];

        int maxRight[] = new int[n];
        maxRight[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) maxRight[i] = (subSum[i] >= subSum[maxRight[i + 1]]) ? i : maxRight[i + 1];

        int ans[] = new int[3];
        int maxSum = 0;
        for (int i = k; i < n - k; i++) {
            int curSum = subSum[maxLeft[i - k]] + subSum[i] + subSum[maxRight[i + k]];
            if (curSum > maxSum) {
                maxSum = curSum;
                ans = new int[] { maxLeft[i - k], i, maxRight[i + k] };
            }
        }
        return ans;
    }
}