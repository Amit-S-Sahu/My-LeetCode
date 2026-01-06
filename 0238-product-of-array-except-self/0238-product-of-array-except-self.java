class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        boolean single = false, multiple = false;
        long prod = 1;
        for (int num : nums) {
            if (num == 0 && !single) single = true;
            else if (num == 0) {
                multiple = true;
                break;
            }
            else prod *= num;
        }
        if (multiple) {
            Arrays.fill(nums, 0);
        }
        else if (single) {
            for (int i = 0; i < n; i++) nums[i] = (nums[i] == 0) ? (int)prod : 0;
        }
        else {
            for (int i = 0; i < n; i++) nums[i] = (int)prod / nums[i];
        }
        return nums;
    }
}