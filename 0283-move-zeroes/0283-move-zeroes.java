class Solution {
    public void moveZeroes(int[] nums) {
        int ans[] = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (i < nums.length && num != 0) {
                ans[i++] = num;
            }
        }
        while (i < nums.length) ans[i++] = 0;

        for (int j = 0; j < nums.length; j++) nums[j] = ans[j];
    }
}