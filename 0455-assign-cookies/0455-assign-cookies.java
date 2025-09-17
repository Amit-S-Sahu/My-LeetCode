class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int i = 0;
        for (int size : s) {
            if (i == g.length) break;
            if (g[i] <= size) {
                ans++;
                i++;
            }
        }
        return ans; 
    }
}