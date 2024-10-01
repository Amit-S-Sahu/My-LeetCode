class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++;
                nums[left++] = 0;
                nums[right--] = 0;
            }
            else if (nums[left] + nums[right] < k) left++;
            else right--;
        }
        return count;
    }
}