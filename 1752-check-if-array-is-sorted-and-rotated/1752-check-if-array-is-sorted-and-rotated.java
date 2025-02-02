class Solution {
    public boolean check(int[] nums) {
        int rotated = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) rotated++;
        }
        if (nums[nums.length - 1] > nums[0]) rotated++;

        return rotated < 2;
    }
}