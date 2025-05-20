class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int diff[] = new int[n + 1];

        for (int query[] : queries) {
            diff[query[0]]++;
            if (query[1] + 1 < n + 1) diff[query[1] + 1]--;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] <= sum) nums[i] = 0;
            else return false;
        }

        return true;
    }
}