class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, k, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private boolean check(int[] nums, int k, int capability) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                count++;
                i++;
            }
            if (count >= k) return true;
        }
        return count >= k;
    }
}