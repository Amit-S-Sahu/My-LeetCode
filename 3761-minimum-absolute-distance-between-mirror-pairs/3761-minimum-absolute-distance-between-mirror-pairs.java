class Solution {
    private int rev(int n) {
        int ans = 0;
        while (n > 0) {
            ans = ans * 10 + (n % 10);
            n /= 10;
        }
        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) ans = Math.min(ans, i - map.get(nums[i]));
            map.put(rev(nums[i]), i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}