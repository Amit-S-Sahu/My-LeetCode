class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int left = 0, right = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) return nums1[left];
            else if (nums1[left] < nums2[right]) left++;
            else right++;
        }
        return -1;
    }
}