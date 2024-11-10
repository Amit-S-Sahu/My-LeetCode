class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int bits[] = new int[32];
        int curr = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            curr |= nums[right];
            
            for (int bit = 0; bit < 32; bit++) {
                if ((nums[right] & (1 << bit)) != 0) bits[bit]++;
            }
            
            while (left <= right && curr >= k) {
                min = Math.min(min, right - left + 1);
                
                int next = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if ((nums[left] & (1 << bit)) != 0) bits[bit]--;
                    if (bits[bit] > 0) next |= (1 << bit);
                }
                curr = next;
                left++;
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}