class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        if (target == start) return 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) min = Math.min(min, Math.abs(i - start));
        }
        return min;
    }
}