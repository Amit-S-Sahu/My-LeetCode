class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) sum = 0;
            sum += nums[i];
            max_sum = Math.max(max_sum, sum);
        }

        if (max_sum == 0) {
            for (int i = 0; i < nums.length; i++) {
                max_sum = Math.max(max_sum, nums[i]);
            }
        }

        return max_sum;
    }
}