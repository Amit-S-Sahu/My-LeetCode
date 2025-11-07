class Solution {
    void dfs(int id, int node, List<List<Integer>> adj, boolean vis[], Map<Integer, TreeSet<Integer>> set, Map<Integer, Integer> map) {
        vis[node] = true;
        set.get(id).add(node);
        map.put(node, id);
        for (int it : adj.get(node)) {
            if (!vis[it]) dfs(id, it, adj, vis, set, map);
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < c; i++) adj.add(new ArrayList<>());

        for (int conn[] : connections) {
            adj.get(conn[0] - 1).add(conn[1] - 1);
            adj.get(conn[1] - 1).add(conn[0] - 1);
        }

        boolean vis[] = new boolean[c];
        boolean online[] = new boolean[c];
        Arrays.fill(online, true);

        int id = 0;
        Map<Integer, TreeSet<Integer>> set = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < c; i++) {
            if (!vis[i]) {
                set.put(id, new TreeSet<>());
                dfs(id, i, adj, vis, set, map);
                id++;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int q[] : queries) {
            int type = q[0];
            int node = q[1] - 1;
            int compId = map.get(node);

            if (type == 2) {
                set.get(compId).remove(node);
                online[node] = false;
                continue;
            }

            if (online[node]) ansList.add(node + 1);
            else if (!set.get(compId).isEmpty()) ansList.add(set.get(compId).first() + 1);
            else ansList.add(-1);
        }

        int ans[] = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) ans[i] = ansList.get(i);
        return ans;
    }
}