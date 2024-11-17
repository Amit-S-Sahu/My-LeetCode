class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long sum[] = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        int queue[] = new int[n + 1]; 
        int left = 0, right = 0; 
        int min = n + 1;
        
        for (int i = 0; i <= n; i++) {
            while (right > left && sum[i] >= sum[queue[left]] + k) {
                min = Math.min(min, i - queue[left++]);
            }
            
            while (right > left && sum[i] <= sum[queue[right - 1]]) {
                right--;
            }
            
            queue[right++] = i;
        }
        
        return min <= n ? min : -1;
    }
}