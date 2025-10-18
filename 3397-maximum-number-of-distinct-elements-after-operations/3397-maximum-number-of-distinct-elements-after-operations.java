class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE, unique = nums.length;
        for (int num : nums)
            if (prev >= num + k) unique--;
            else prev = Math.max(prev + 1, num - k);
        return unique;
    }
}