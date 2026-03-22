class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int m = mat.length;
        int n = mat[0].length;

        for (int k = 0; k < 4; k++) {
            boolean check = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != target[i][j]) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) return true;
            for (int i = 0; i < m; i++) {
                for (int j = i; j < n; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[i][n - 1 - j];
                    mat[i][n - 1 - j] = temp;
                }
            }
        }
        return false;
    }
}