class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = nums.length - 1;
        while (left < n - 1 && nums[left] == nums[n - 1]) left++;
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] <= nums[right]) right = mid;
            else left = mid + 1;
        }

        return nums[left];
    }
}