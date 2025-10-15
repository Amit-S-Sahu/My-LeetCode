class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int inc = 1, prevInc = 0, max = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) inc++;
            else {
                prevInc = inc;
                inc = 1;
            }
            max = Math.max(max, Math.max(inc >> 1, Math.min(prevInc, inc)));
        }
        return max;
    }
}