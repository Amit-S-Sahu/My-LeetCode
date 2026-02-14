class Solution {
    boolean visited[];
    private void dfs(int node, int adj[][]) {
        if (visited[node]) return;
        visited[node] = true;
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1) dfs(i, adj);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected);
                components++;
            }
        }
        return components;
    }
}