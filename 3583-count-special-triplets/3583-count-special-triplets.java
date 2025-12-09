class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        if (n < 3) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (!map.containsKey(2 * nums[i])) continue;
            List<Integer> temp = map.get(2 * nums[i]);
            int prev = 0, next = 0;
            for (int num : temp) {
                if (num < i) prev++;
                else if (num > i) next++;
            }
            if (prev > 0 && next > 0) ans = (ans + (prev * next) % mod) % mod;
        }

        return ans;
    }
}