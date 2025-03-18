class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        int left = 0;
        int bits = 0;
        
        for (int right = 0; right < n; right++) {
            while ((bits & nums[right]) != 0) {
                bits ^= nums[left];
                left++;
            }
            
            bits |= nums[right];
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}