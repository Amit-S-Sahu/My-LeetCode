class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        boolean found = false;
        int i = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                i = mid;
                found = true;
                break;
            }
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (!found) return new int[]{-1, -1};
        left = i;
        right = i;
        while (left >= 0 && nums[left] == target) left--;
        while (right < nums.length && nums[right] == target) right++;
        return new int[]{left + 1, right - 1};
    }
}