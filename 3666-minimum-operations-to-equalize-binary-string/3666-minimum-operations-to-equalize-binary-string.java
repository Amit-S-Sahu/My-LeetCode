class Solution {
    public int minOperations(String s, int k) {
        int n = s.length(), u = 0;
        int dist[] = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        List<TreeSet<Integer>> list = new ArrayList<>();
        list.add(new TreeSet<>());
        list.add(new TreeSet<>());
        for(int i = 0; i <= n; i++){
            list.get(i % 2).add(i);
            if (i < n && s.charAt(i) == '0') u++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(u);
        dist[u] = 0;
        list.get(u % 2).remove(u);
        while(!q.isEmpty()){
            u = q.poll();
            int c1 = Math.max(k - n + u, 0), c2 = Math.min(u, k);
            int left = u + k - 2 * c2, right = u + k - 2 * c1;
            TreeSet<Integer> node = list.get(left % 2);
            for (Integer v = node.ceiling(left); v != null && v <= right; v = node.ceiling(left)) {
                dist[v] = dist[u] + 1;
                q.offer(v);
                node.remove(v);
            }
        }
        return dist[0] == Integer.MAX_VALUE ? -1 : dist[0];
    }
}