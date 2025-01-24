class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        
        if (graph == null || graph.length == 0) {
            return res;
        }

        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph, i, color)) {
                res.add(i);
            }
        }

        return res; 
    }

    private boolean isSafe(int[][] graph, int node, int[] color) {
        if (color[node] != 0) {
            return color[node] == 1; 
        }

        color[node] = 2;

        for (int neighbor : graph[node]) {
            if (!isSafe(graph, neighbor, color)) {
                return false;
            }
        }

        color[node] = 1;
        return true;
    }
}