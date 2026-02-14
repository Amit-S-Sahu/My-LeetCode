class Solution {
    int dirX[] = {1, -1, 0, 0};
    int dirY[] = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 1;
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.addLast(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        q.addLast(new int[]{-1, -1});

        if (fresh == 0) return 0;
        while (!q.isEmpty()) {
            int curr[] = q.removeFirst();
            if (curr[0] == -1 && !q.isEmpty()) {
                ans++;
                q.addLast(new int[]{-1, -1});
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dirX[i];
                int ny = curr[1] + dirY[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] == 1) {
                    q.addLast(new int[]{nx, ny});
                    grid[nx][ny] = 2;
                    fresh--;
                }
                if (fresh == 0) return ans;
            }
        }
        return fresh == 0 ? ans : -1;
    }
}