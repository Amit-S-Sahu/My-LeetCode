class Solution {
    public int maxSum(int[] nums) {
        int min = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int val : nums) {
            if (!set.contains(val)) {
                if (val >= 0) sum += val;
                else min = Math.max(min, val);
            }
            set.add(val);
        }

        return (sum == 0 && !set.contains(0)) ? min : sum;
    }
}