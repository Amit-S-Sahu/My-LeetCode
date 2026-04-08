class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = (int)1e9 + 7;
        for (int query[] : queries) {
            int i = query[0];
            while (i <= query[1]) {
                nums[i] = (int)(nums[i] * (long)query[3] % mod) % mod;
                i += query[2];
            }
        }
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }
}