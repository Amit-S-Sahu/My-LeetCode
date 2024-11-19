class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long sum = 0, max = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            while (set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            if (set.size() == k) {
                max = Math.max(max, sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }

        return max;
    }
}