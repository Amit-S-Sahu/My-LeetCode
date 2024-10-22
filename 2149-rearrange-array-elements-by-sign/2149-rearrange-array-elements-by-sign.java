class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int pos[] = new int[len / 2];
        int neg[] = new int[len / 2];
        int p = 0, n = 0;
        for (int num : nums) {
            if (num < 0) neg[n++] = num;
            else pos[p++] = num;
        }
        p = 0;
        n = 0;
        int i = 0;
        while (i < len) {
            nums[i++] = pos[p++];
            nums[i++] = neg[n++];
        }

        return nums;
    }
}