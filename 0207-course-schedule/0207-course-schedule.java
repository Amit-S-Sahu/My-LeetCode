class Solution {
    private boolean hasCycle(int node, List<List<Integer>> graph, boolean visited[], boolean onStack[]) {
        visited[node] = true;
        onStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor] && hasCycle(neighbor, graph, visited, onStack)) return true;
            if (onStack[neighbor]) return true;
        }
        onStack[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int p[] : prerequisites) {
            if (p[0] == p[1]) return false;
            graph.get(p[1]).add(p[0]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean onStack[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, graph, visited, onStack)) return false;
        }
        return true;
    }
}
