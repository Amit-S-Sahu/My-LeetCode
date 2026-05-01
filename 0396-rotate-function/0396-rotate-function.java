class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long temp = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            temp += (long) i * nums[i];
        }

        long ans = temp;
        for (int i = 1; i < n; i++) {
            temp = temp + sum - (long) n * nums[n - i];
            ans = Math.max(ans, temp);
        }

        return (int) ans;
    }
}