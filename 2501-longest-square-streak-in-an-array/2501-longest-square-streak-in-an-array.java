class Solution {
    public int longestSquareStreak(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        int ans = 1;
        while(!set.isEmpty()) {
            int curr = set.first();
            int streak = 0;
            while(!set.isEmpty() && set.contains(curr)) {
                set.remove(curr);
                curr = curr * curr;
                streak++;
            }     
            ans = Math.max(streak, ans);
        }
        return ans == 1 ? -1 : ans;
    }
}