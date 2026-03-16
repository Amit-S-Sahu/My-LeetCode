class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> best = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                best.add(grid[i][j]);
                if (best.size() > 3) best.pollFirst();

                for (int rad = 1; i + 2 * rad < m && j - rad >= 0 && j + rad < n; rad++) {
                    int sum = 0;
                    for (int k = 0; k < rad; k++) sum += grid[i + k][j + k];
                    for (int k = 0; k < rad; k++) sum += grid[i + rad + k][j + rad - k];
                    for (int k = 0; k < rad; k++) sum += grid[i + 2 * rad - k][j - k];
                    for (int k = 0; k < rad; k++) sum += grid[i + rad - k][j - rad + k];
                    best.add(sum);
                    if (best.size() > 3) best.pollFirst();
                }
            }
        }

        int ans[] = new int[best.size()];
        int i = 0;
        for (int num : best.descendingSet()) ans[i++] = num;
        return ans;
    }
}