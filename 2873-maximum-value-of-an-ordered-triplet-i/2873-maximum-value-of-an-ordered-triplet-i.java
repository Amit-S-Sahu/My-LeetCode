class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0, max = 0, diff = 0;
        for (int num : nums) {
            ans = Math.max(ans, diff * num);
            diff = Math.max(diff, max - num);
            max = Math.max(max, num);
        }
        return ans;
    }
}