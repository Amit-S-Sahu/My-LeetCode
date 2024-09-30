class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m + n;
        int ans[] = new int[l];

        int i = 0, j = 0, k = 0;

        while ((i < m) && (j < n)) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            }
            else if(nums1[i] > nums2[j]) {
                ans[k++] = nums2[j++];
            }
            else {
                ans[k++] = nums1[i++];
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }

        while (j < n) {
            ans[k++] = nums2[j++];
        }

        if (l % 2 != 0) return (double)ans[l / 2];
        int temp = ans[l / 2] + ans[(l / 2) - 1];
        return (double)temp / 2.0;
    }
}