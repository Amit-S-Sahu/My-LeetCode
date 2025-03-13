class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int sum = 0, count = 0;
        int diff[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            while (sum + diff[i] < nums[i]) {
                count++;
                if (count > queries.length) return -1;

                int left = queries[count - 1][0];
                int right = queries[count - 1][1];
                int value = queries[count - 1][2];

                if (right >= i) {
                    diff[Math.max(left, i)] += value;
                    if (right + 1 < diff.length) diff[right + 1] -= value;
                }
            }
            sum += diff[i];
        }
        return count;
    }
}
