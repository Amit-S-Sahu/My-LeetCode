class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int minRolls[] = new int[n * n + 1];
        Arrays.fill(minRolls, -1);
        Queue<Integer> q = new LinkedList<>();
        minRolls[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= 6 && x + i <= n * n; i++) {
                int t = x + i;
                int row = (t - 1) / n;
                int col = (t - 1) % n;
                int v = board[n - 1 - row][(row % 2 == 1) ? (n - 1 - col) : col];
                int y = (v > 0 ? v : t);
                if (y == n * n) return minRolls[x] + 1;
                if (minRolls[y] == -1) {
                    minRolls[y] = minRolls[x] + 1;
                    q.offer(y);
                }
            }
        }

        return -1;
    }
}