class Solution {
    private int getBits(int num, int count) {
        if (num == 0) return count;
        // if ((num & 1) != 0) return getBits(num >> 1, count + 1);
        // return getBits(num >> 1, count);
        return getBits(num >> 1, count + (num & 1));
    }

    private boolean checkSorted(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }

    public boolean canSortArray(int[] nums) {
        if (nums.length == 1) return true;
        if (checkSorted(nums)) return true;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1] && getBits(nums[i], 0) == getBits(nums[i + 1], 0)) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return checkSorted(nums);
    }
}