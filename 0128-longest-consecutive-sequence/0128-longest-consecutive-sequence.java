class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int ans = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int curr = num;
                
                while (set.contains(curr + 1)) {
                    count++;
                    curr++;
                }
                
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
}
