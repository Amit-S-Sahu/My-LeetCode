class Solution {
    private int dx[] = {1, -1, 0, 0};
    private int dy[] = {0, 0, 1, -1};

    private boolean dfs(char board[][], int i, int j, int curr, String word) {
        if (curr == word.length() - 1) return true;
        char temp = board[i][j];
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            if (board[nr][nc] == word.charAt(curr + 1) && dfs(board, nr, nc, curr + 1, word)) {
                board[i][j] = temp;
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char first = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == first) {
                    if (dfs(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }
}