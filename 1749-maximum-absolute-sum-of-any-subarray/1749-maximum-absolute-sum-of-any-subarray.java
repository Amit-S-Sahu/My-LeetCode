class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum = 0, min_sum = 0, maxEnd = 0, minEnd = 0;

        for (int num : nums) {
            maxEnd += num;
            minEnd += num;

            max_sum = Math.max(max_sum, maxEnd);
            min_sum = Math.min(min_sum, minEnd);

            if (maxEnd < 0) maxEnd = 0;
            if (minEnd > 0) minEnd = 0;
        }

        return Math.max(max_sum, Math.abs(min_sum));
    }
}