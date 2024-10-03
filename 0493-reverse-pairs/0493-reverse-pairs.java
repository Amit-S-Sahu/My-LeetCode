class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergesort(nums, 0, nums.length-1);
        return count;
    }
    public void mergesort(int nums[], int left, int right) {
        if (left>=right) {
            return;
        }
        int mid = (left+right)/2;
        mergesort(nums, left, mid);
        mergesort(nums, mid+1, right);
        countpairs(nums, left, mid, right);
        merge(nums, left, mid, right);
    }
    public void merge(int nums[], int left, int mid, int right) {
        int idx1 = left;
        int idx2 = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (idx1<=mid && idx2<=right) {
            if (nums[idx1] <= nums[idx2]) {
                temp.add(nums[idx1]);
                idx1++;
            }
            else {
                temp.add(nums[idx2]);
                idx2++;
            }
        }
        while (idx1<=mid) {
            temp.add(nums[idx1]);
            idx1++;
        }
        while (idx2<=right) {
            temp.add(nums[idx2]);
            idx2++;
        }
        for (int i=left; i<=right; i++) {
            nums[i] = temp.get(i-left);
        }
    }
    public void countpairs(int nums[], int low, int mid, int high) {
        int right = mid+1;
        for (int i=low; i<=mid; i++) {
            while(right<=high && (long)nums[i]>(long)2*(long)nums[right]) {
                right++;
            }
            count += (right-(mid+1));
        }
    }
}