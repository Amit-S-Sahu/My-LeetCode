class Solution {
    static final int MOD = 1000000007, LOG = 17;
    int up[][];
    int depth[];
    List<Integer>[] g;

    void dfs(int u, int p) {
        up[0][u] = p;
        for (int v : g[u])
            if (v != p) { 
                depth[v] = depth[u] + 1; 
                dfs(v, u); 
            }
    }

    int lca(int a, int b) {
        if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
        for (int k = LOG-1; k >= 0; k--)
            if (up[k][a] != -1 && depth[up[k][a]] >= depth[b]) a = up[k][a];
        if (a == b) return a;
        for (int k = LOG-1; k >= 0; k--)
            if (up[k][a] != up[k][b]) { 
                a = up[k][a]; 
                b = up[k][b]; 
            }
        return up[0][a];
    }

    long modpow(long a, long b) {
        long r = 1;
        while (b > 0) {
            if ((b & 1) == 1) r = r * a % MOD;
            a = a * a % MOD; b >>= 1;
        }
        return r;
    }

    @SuppressWarnings("unchecked")
    public int[] assignEdgeWeights(int[][] edges, int[][] q) {
        int n = edges.length + 1;
        g = new List[n + 1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        depth = new int[n + 1];
        up = new int[LOG][n + 1];
        for (int[] row : up) Arrays.fill(row, -1);

        for (int[] e : edges) { g[e[0]].add(e[1]); g[e[1]].add(e[0]); }
        dfs(1, -1);

        for (int k = 1; k < LOG; k++)
            for (int i = 1; i <= n; i++)
                if (up[k-1][i] != -1) up[k][i] = up[k-1][up[k-1][i]];

        int ans[] = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int a = lca(q[i][0], q[i][1]);
            int d = depth[q[i][0]] + depth[q[i][1]] - 2 * depth[a];
            ans[i] = (int)(d > 0 ? modpow(2, d - 1) : 0);
        }
        return ans;
    }
}