class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            int w1 = passingFees[v];
            int w2 = passingFees[u];

            List<Integer> curr1 = new ArrayList<>();
            curr1.add(v);
            curr1.add(w1);
            curr1.add(t);
            List<Integer> curr2 = new ArrayList<>();
            curr2.add(u);
            curr2.add(w2);
            curr2.add(t);

            adj.get(u).add(curr1);
            adj.get(v).add(curr2);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int dist[][] = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = passingFees[0];
        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int top[] = pq.poll();
            int d = top[0];
            int t = top[1];
            int u = top[2];
            if (u == n - 1) return d;
            if (d != dist[u][t]) continue;

            for (List<Integer> e : adj.get(u)) {
                int v = e.get(0);
                int w = e.get(1);
                int dt = e.get(2);

                if (dt + t <= maxTime) {
                    if (d + w < dist[v][dt + t]) {
                        dist[v][dt + t] = d + w;
                        pq.offer(new int[]{w + d, dt + t, v});
                    }
                }
            }
        }
        return -1;
    }
}