class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            long temp = 0;

            while (j < n && nums[j - 1] < nums[j]) j++;
            int k = j - 1;

            if (k == i) continue;

            temp += nums[k] + nums[k - 1];
            while (j < n && nums[j - 1] > nums[j]) {
                temp += nums[j];
                j++;
            }
            int m = j - 1;

            if (m == k || m == n - 1 || (j < n && nums[j] <= nums[m])) {
                i = m;
                continue;
            }

            temp += nums[m + 1];

            long max = 0;
            long sum = 0;
            for (int p = m + 2; p < n && nums[p] > nums[p - 1]; p++) {
                sum += nums[p];
                max = Math.max(max, sum);
            }
            temp += max;

            max = 0;
            sum = 0;
            for (int p = k - 2; p >= i; p--) {
                sum += nums[p];
                max = Math.max(max, sum);
            }
            temp += max;

            ans = Math.max(ans, temp);
            i = m - 1;
        }

        return ans;
    }
}