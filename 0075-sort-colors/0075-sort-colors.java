class Solution {
    public void sortColors(int[] nums) {
        int count[] = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int i = 0;
        while (i < nums.length) {
            if (count[0] != 0) {
                nums[i++] = 0;
                count[0]--;
            }
            else if (count[1] != 0) {
                nums[i++] = 1;
                count[1]--;
            }
            else if (count[2] != 0) {
                nums[i++] = 2;
                count[2]--;
            }
        }
    }
}