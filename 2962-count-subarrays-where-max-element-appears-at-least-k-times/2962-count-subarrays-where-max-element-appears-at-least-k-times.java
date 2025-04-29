class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long res = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.getOrDefault(max, 0) >= k) {
                while (left < nums.length && map.getOrDefault(max, 0) >= k) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    left++;
                }
            }
            res += left;
        }
        return res;
    }
}