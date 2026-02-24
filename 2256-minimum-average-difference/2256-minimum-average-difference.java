class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long total = 0;
        for (int num : nums) total += num;

        long left = 0;
        long best = Long.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            left += nums[i];
            long right = total - left;

            long leftAvg = left / (i + 1);
            long rightAvg = (i == n - 1) ? 0 : (right / (n - i - 1));

            long diff = Math.abs(leftAvg - rightAvg);
            if (diff < best) {
                best = diff;
                ans = i;
            }
        }
        return ans;
    }
}