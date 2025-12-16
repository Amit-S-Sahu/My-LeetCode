class Solution {
    List<Integer>[] tree;
    int[] buyPrice, sellPrice;
    int budget;
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.buyPrice = present;
        this.sellPrice = future;
        this.budget = budget;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int h[] : hierarchy) {
            int boss = h[0] - 1;
            int emp  = h[1] - 1;
            tree[boss].add(emp);
        }
        int dp[][] = dfs(0);
        return dp[budget][0];
    }

    public int[][] dfs(int u) {
        int dp[][] = new int[budget + 1][2];
        for (int v : tree[u]) {
            int child[][] = dfs(v);
            int next[][] = new int[budget + 1][2];

            for (int b = 0; b <= budget; b++) {
                for (int cb = 0; cb <= b; cb++) {
                    next[b][0] = Math.max(next[b][0], dp[b - cb][0] + child[cb][0]);
                    next[b][1] = Math.max(next[b][1], dp[b - cb][1] + child[cb][1]);
                }
            }
            dp = next;
        }

        int ans[][] = new int[budget + 1][2];

        for (int b = 0; b <= budget; b++) {
            ans[b][0] = dp[b][0];
            if (b >= buyPrice[u]) {
                ans[b][0] = Math.max(ans[b][0], sellPrice[u] - buyPrice[u] + dp[b - buyPrice[u]][1]);
            }

            int discounted = buyPrice[u] / 2;
            ans[b][1] = dp[b][0];
            if (b >= discounted) {
                ans[b][1] = Math.max(ans[b][1], sellPrice[u] - discounted + dp[b - discounted][1]);
            }
        }
        return ans;
    }
}