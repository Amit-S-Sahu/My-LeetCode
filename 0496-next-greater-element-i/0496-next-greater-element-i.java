class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //int n = nums1.length;
        //int m = nums2.length;
        //
        //HashMap<Integer, Integer> map = new HashMap<>();
        //int ans[] = new int[n];
        //for (int num : nums1) {
        //    for (int i = 0; i < m; i++) {
        //        if (nums2[i] == num) map.put(num, i);
        //    }
        //}
        //for (int i = 0; i < n; i++) {
        //    ans[i] = -1;
        //    for (int j = map.get(nums1[i]); j < m; j++) {
        //        if (nums2[j] > nums1[i]) {
        //            ans[i] = nums2[j];
        //            break;
        //        }
        //    }
        //}
        //return ans;
        // -------
        //int n = nums1.length;
        //int m = nums2.length;
        //int ans[] = new int[n];
        //for (int i = 0; i < n; i++) {
        //    int j = 0;
        //    ans[i] = -1;
        //    while (j < m && nums2[j] != nums1[i]) j++;
        //    while (j < m) {
        //        if (nums2[j] > nums1[i]) {
        //            ans[i] = nums2[j];
        //            break;
        //        }
        //        j++;
        //    }
        //}
        //return ans;
        // --------
        ArrayDeque<Integer> s = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!s.isEmpty() && num > s.peek()) map.put(s.pop(), num);
            s.push(num);
        }
        for (int num : s) map.put(num, -1);
        for (int i = 0; i < nums1.length; i++) nums1[i] = map.get(nums1[i]);        
        return nums1;
    }
}