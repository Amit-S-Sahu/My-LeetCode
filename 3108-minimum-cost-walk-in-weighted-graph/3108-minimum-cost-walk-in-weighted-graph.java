class Solution {
    private int findRoot(int[] parent, int node) {
        if (parent[node] != node) parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int parent[] = new int[n];
        int min[] = new int[n];
        Arrays.fill(min, -1);

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int edge[] : edges) {
            int source = edge[0], target = edge[1], weight = edge[2];
            int sourceRoot = findRoot(parent, source);
            int targetRoot = findRoot(parent, target);

            min[targetRoot] &= weight;

            if (sourceRoot != targetRoot) {
                min[targetRoot] &= min[sourceRoot];
                parent[sourceRoot] = targetRoot;
            }
        }

        int result[] = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int start = query[i][0], end = query[i][1];
            if (start == end) result[i] = 0;
            else if (findRoot(parent, start) != findRoot(parent, end)) result[i] = -1;
            else result[i] = min[findRoot(parent, start)];
        }
        return result;
    }
}