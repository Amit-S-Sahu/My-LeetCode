class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pref[] = new int[n];
        int suff = Integer.MAX_VALUE;

        pref[0] = nums[0];
        for (int i = 1; i < n; i++) pref[i] = Math.max(pref[i - 1], nums[i]);
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || pref[i] <= suff) ans[i] = pref[i];
            else ans[i] = ans[i + 1]; 
            suff = Math.min(suff, nums[i]);
        }
        return ans;
    }
}