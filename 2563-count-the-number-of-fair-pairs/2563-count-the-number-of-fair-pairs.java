class Solution{
    private long countAtLeast(int[] nums, long comp) {
        long ans = 0; int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] >= comp) {
                ans += j - i;
                j--;
            }
            else i++;
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countAtLeast(nums, lower) - countAtLeast(nums, upper+1);
    }
}