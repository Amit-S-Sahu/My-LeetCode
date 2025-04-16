class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0; int left = 0;
        for (int i = 0; i < nums.length; i++) {
            k -= map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (k <= 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                k += map.get(nums[left++]);
            }
            count += left;
        }
        return count;
    }
}