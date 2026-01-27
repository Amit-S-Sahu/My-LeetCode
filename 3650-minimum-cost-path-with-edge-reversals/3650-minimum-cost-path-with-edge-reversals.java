class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            List<Integer> curr1 = new ArrayList<>();
            List<Integer> curr2 = new ArrayList<>();

            curr1.add(v);
            curr1.add(w);
            curr2.add(u);
            curr2.add(2 * w);

            adj.get(u).add(curr1);
            adj.get(v).add(curr2);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()) {
            int top[] = pq.poll();
            int d = top[0];
            int u = top[1];
            if (d > dist[u]) continue;

            for (List<Integer> e : adj.get(u)) {
                int v = e.get(0);
                int w = e.get(1);

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}