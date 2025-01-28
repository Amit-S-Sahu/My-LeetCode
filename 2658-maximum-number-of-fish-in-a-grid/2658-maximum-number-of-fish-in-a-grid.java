class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length, mxFish = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) mxFish = Math.max(mxFish, bfs(i, j, grid));
            }
        }
        return mxFish;
    }

    private int bfs(int i, int j, int[][] grid) {
        int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int fish = grid[i][j];
        grid[i][j] = 0;

        while (!queue.isEmpty()) {
            int cell[] = queue.poll();
            int x = cell[0], y = cell[1];
            for (int d[] : directions) {
                int a = x + d[0], b = y + d[1];
                if (a >= 0 && a < n && b >= 0 && b < m && grid[a][b] > 0) {
                    queue.add(new int[]{a, b});
                    fish += grid[a][b];
                    grid[a][b] = 0;
                }
            }
        }
        return fish;
    }
}