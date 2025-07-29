class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int last[] = new int[32];

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) last[b] = i;
            }
            int max = i;
            for (int b = 0; b < 32; b++) {
                max = Math.max(max, last[b]);
            }
            ans[i] = max - i + 1;
        }
        return ans;
    }
}
