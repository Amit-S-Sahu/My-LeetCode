class Solution {
    private static final int MOD = 1000000007;
    private static int[] fact, inv;
    private int[] size, ways;

    private static int modPow(long base, int exp) {
        base %= MOD;
        long ans = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) ans = ans * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return (int)ans;
    }

    private static int inverse(int num) {
        return modPow(num, MOD - 2);
    }

    private static int nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (int)((long) fact[n] * inv[r] % MOD * inv[n - r] % MOD);
    }

    private void dfs(List<List<Integer>> adj, int node) {
        int currSize = 1;
        int currWays = 1;
        for (int v : adj.get(node)) {
            dfs(adj, v);
            currWays = (int)((long) currWays * ways[v] % MOD);
            currWays = (int)((long) currWays * nCr(currSize - 1 + size[v], size[v]) % MOD);
            currSize += size[v];
        }
        size[node] = currSize;
        ways[node] = currWays % MOD;
    }

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        fact = new int[n + 1];
        inv = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (int)((long)fact[i - 1] * i % MOD);
        }
        inv[n] = inverse(fact[n]);
        for (int i = n; i >= 1; i--) {
            inv[i - 1] = (int)((long)inv[i] * i % MOD);
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            adj.get(prevRoom[i]).add(i);
        }

        size = new int[n];
        ways = new int[n];

        dfs(adj, 0);
        return ways[0];
    }
}