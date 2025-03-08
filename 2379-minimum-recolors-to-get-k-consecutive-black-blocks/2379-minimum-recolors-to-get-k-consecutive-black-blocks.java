class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count = 0, ans = Integer.MAX_VALUE;
    
        for (int i = 0; i < blocks.length(); i++) {
            if (i - k >= 0 && blocks.charAt(i - k) == 'B') count--;
            if (blocks.charAt(i) == 'B') count++;
            ans = Math.min(ans, k - count);
        }
        
        return ans;
    }
}