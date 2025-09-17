class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int curr = 1;
            int i = num + 1;
            while (set.contains(i)) {
                i++;
                curr++;
            }
            ans = Math.max(ans, curr);
            if (ans > nums.length / 2) break;
        }
        return ans;
    }
}