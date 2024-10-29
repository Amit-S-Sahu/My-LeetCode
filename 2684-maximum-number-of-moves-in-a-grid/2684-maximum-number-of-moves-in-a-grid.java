class Solution {
    int max = 0;
    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            getMoves(grid, i, 0, 0, 0);
        }
        return max;
    }

    private void getMoves(int[][] grid, int i, int j, int steps, int prev) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] > 0 && Math.abs(grid[i][j]) > Math.abs(prev)) {
            grid[i][j] = -grid[i][j];
            max = Math.max(max, steps);
            getMoves(grid, i - 1, j + 1, steps + 1, grid[i][j]);
            getMoves(grid, i, j + 1, steps + 1, grid[i][j]);
            getMoves(grid, i + 1, j + 1, steps + 1, grid[i][j]);
        }
    }
}