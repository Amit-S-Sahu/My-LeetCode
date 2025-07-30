class Solution {
    public int longestSubarray(int[] nums) {
        int len = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int temp = 0;
        for (int num : nums) {
            if (num == max) temp++;
            else {
                len = Math.max(len, temp);
                temp = 0;
            }
        }
        len = Math.max(len, temp);

        return len;
    }
}