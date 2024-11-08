class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int curr = nums[0];
        // int max = (int)Math.pow(2, maximumBit) - 1;
        int max = (1 << maximumBit) - 1;

        for (int i = 1; i < nums.length; i++) curr ^= nums[i];
        int ans[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = curr ^ max;
            curr ^= nums[nums.length - 1- i];
        }

        return ans;
    }
}