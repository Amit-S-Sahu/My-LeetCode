class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int map[] = new int[100];
        for (int[] d : dominoes) 
            if (d[0] > d[1]) map[d[0] * 10 + d[1]]++;
            else map[d[1] * 10 + d[0]]++;
        
        int count = 0;
        for (int freq : map) count += (freq - 1) * freq / 2;
        
        return count;
    }
}