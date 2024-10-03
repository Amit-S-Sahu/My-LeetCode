class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergesort(nums, 0, nums.length-1);
        return count;
    }
    private void mergesort(int nums[], int left, int right) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);
        countpairs(nums, left, mid, right);
        merge(nums, left, mid, right);
    }

    private void merge(int nums[], int left, int mid, int right) {
        int i1 = left;
        int i2 = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i1 <= mid && i2 <= right) {
            if (nums[i1] <= nums[i2]) temp.add(nums[i1++]);
            else temp.add(nums[i2++]);
        }

        while (i1 <= mid) temp.add(nums[i1++]);
        while (i2 <= right) temp.add(nums[i2++]);

        for (int i = left; i <= right; i++) {
            nums[i] = temp.get(i-left);
        }
    }

    private void countpairs(int nums[], int low, int mid, int high) {
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while(right <= high && (long)nums[i] > (long)2 * (long)nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
    }
}