class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        boolean hasZero = false, multipleZero = false;
        for (int num : nums) {
            if (num == 0 && !hasZero) {
                hasZero = true;
                continue;
            }
            if (num == 0 && hasZero) {
                multipleZero = true;
                break;
            }

            prod *= num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (multipleZero) {
                nums[i] = 0;
                continue;
            }
            if (hasZero) {
                if (nums[i] != 0) nums[i] = 0;
                else nums[i] = prod;
            }
            else nums[i] = prod / nums[i];
        }

        return nums;
    }
}