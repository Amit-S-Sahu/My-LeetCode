class Solution {
    private int sum(int n) {
        int res = 0;

        while (n > 0) {
            res += (n % 10);
            n /= 10;
        }
        return res;
    }

    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sum(nums[i]);
            res = Math.min(nums[i], res);
        }
        return res;
    }
}