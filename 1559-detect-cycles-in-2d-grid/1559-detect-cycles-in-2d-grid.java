class Solution {
    private int m, n;
    private char grid[][];
    private boolean visited[][];
    private boolean inStack[][];

    private int dx[] = {1, -1, 0, 0};
    private int dy[] = {0, 0, 1, -1};

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];
        inStack = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j])) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int px, int py, char ch) {
        visited[x][y] = true;
        inStack[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (grid[nx][ny] != ch) continue;

            if (nx == px && ny == py) continue;

            if (inStack[nx][ny]) return true;

            if (!visited[nx][ny]) {
                if (dfs(nx, ny, x, y, ch)) return true;
            }
        }

        inStack[x][y] = false;
        return false;
    }
}