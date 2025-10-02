class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = 0;
                if (i == 0) temp = prefix[j];
                else temp = prefix[j] - prefix[i - 1];

                if (temp == k) count++;
            }
        }

        return count;
    }
}