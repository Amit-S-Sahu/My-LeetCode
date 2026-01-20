class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n  = nums.size();
        int ans[] = new int[n];
        int i = 0;
        for (int num : nums) {
            boolean found = false;
            for (int j = 0; j <= num; j++) {
                if ((j | (j + 1)) == num) {
                    found = true;
                    ans[i++] = j;
                    break;
                }
            }
            if (!found) ans[i++] = -1;
        }
        return ans;
    }
}