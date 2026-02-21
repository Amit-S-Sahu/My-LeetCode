class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans[][] = new int[m][n];

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.addLast(new int[]{i, j});
                }
            }
        }

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int curr[] = q.removeFirst();
            int x = curr[0];
            int y = curr[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (ans[nx][ny] != -1) continue;
                ans[nx][ny] = ans[x][y] + 1;
                q.addLast(new int[]{nx, ny});
            }
        }
        return ans;
    }
}