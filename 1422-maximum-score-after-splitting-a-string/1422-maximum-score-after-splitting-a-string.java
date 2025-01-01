class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int current = s.charAt(0) == '0' ? 1 : 0; 
        int score = current;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') current++; 
            else { 
                ones++; 
                current--; 
            }
            score = Math.max(score, current);
        }
        return ones + score + (s.charAt(s.length() - 1) == '1' ? 1 : 0);
    }
}