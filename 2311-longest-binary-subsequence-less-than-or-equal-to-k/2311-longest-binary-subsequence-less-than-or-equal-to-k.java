class Solution {
    public int longestSubsequence(String s, int k) {
        int sm = 0;
        int count = 0;
        int bits = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1') {
                if (i < bits && sm + (1 << i) <= k) {
                    sm += 1 << i;
                    count++;
                }
            } 
            else count++;
        }
        return count;
    }
}