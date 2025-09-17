class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int key = nums2[i];
            int j = m - 1;
            while (j >= 0 && nums1[j] > key) {
                nums1[j + 1] = nums1[j];
                j--;
            }
            nums1[j + 1] = key;
            m++;
        }
    }
}