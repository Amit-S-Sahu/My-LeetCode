class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int total_count = Integer.MIN_VALUE;
        int curr_count = 0;

        for (int num : nums) {
            if (num == 1) curr_count++;
            else {
                total_count = Math.max(total_count, curr_count);
                curr_count = 0;
            } 
        }
        
        return Math.max(total_count, curr_count);
    }
}