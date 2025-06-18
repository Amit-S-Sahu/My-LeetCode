class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 3 != 0) return new int[0][];
        
        int res[][] = new int[n / 3][3];
        for (int i = 0, j = 0; i < n; i += 3, j++) {
            if (nums[i + 2] - nums[i] > k) return new int[0][];
            res[j][0] = nums[i];
            res[j][1] = nums[i + 1];
            res[j][2] = nums[i + 2];
        }
        return res;
    }
}
