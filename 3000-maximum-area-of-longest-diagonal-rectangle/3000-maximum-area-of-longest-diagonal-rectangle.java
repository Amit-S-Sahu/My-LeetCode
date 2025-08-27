class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = -1.0;
        int ans = 0;
        
        for (int rect[] : dimensions) {
            int l = rect[0], b = rect[1];
            double w = Math.sqrt((double)l * l + (double)b * b);
            
            if (w > max) {
                max = w;
                ans = l * b;
            } 
            else if (w == max) ans = Math.max(ans, l * b);
        }
        
        return ans;
    }
}