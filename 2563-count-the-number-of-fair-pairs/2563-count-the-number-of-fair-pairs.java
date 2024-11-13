class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;

        for (int left = 0; left < nums.length - 1; left++) {
            int start = left + 1;
            int end = nums.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[left] + nums[mid] >= lower) end = mid - 1;
                else start = mid + 1;
            }
            int low = start;

            start = left + 1;
            end = nums.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[left] + nums[mid] <= upper) start = mid + 1;
                else end = mid - 1;
            }
            int high = end;

            if (low <= high) ans += (high - low + 1);
        }
        return ans;
    }
}
