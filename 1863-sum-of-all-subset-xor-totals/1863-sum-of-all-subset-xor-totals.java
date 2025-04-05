class Solution {
    public int subsetXORSum(int[] nums) {
        int total = 0;
        for (int num : nums) total |= num;

        int mul = 1 << (nums.length - 1);
        return total * mul;
    }
}