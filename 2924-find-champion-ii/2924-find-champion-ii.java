class Solution {
    public int findChampion(int n, int[][] edges) {
        int in_degree[] = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            in_degree[v]++;
        }

        int champion = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (in_degree[i] == 0) {
                champion++;
                ans = i;
            }
        }

        if (champion > 1) return -1;
        return ans;
    }
}