class Solution {
    private int n;
    private int grid[][];
    private Map<Integer, Integer> map = new HashMap<>();
    private static final int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int color = 2;
        int area = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, color);
                    map.put(color, size);
                    area = Math.max(area, size);
                    color++;
                } 
                else hasZero = true;
            }
        }

        if (!hasZero) return area;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int curr = 1;
                    
                    for (int dir[] : directions) {
                        int x = i + dir[0], y = j + dir[1];
                        if (isValid(x, y) && grid[x][y] > 1 && set.add(grid[x][y])) {
                            curr += map.get(grid[x][y]);
                        }
                    }
                    
                    area = Math.max(area, curr);
                }
            }
        }
        
        return area;
    }

    private int dfs(int i, int j, int color) {
        if (!isValid(i, j) || grid[i][j] != 1) return 0;
        
        grid[i][j] = color;
        int size = 1;
        
        for (int dir[] : directions) {
            size += dfs(i + dir[0], j + dir[1], color);
        }
        
        return size;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}