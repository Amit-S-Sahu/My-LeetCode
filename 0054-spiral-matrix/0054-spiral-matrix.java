class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int topRow = -1, botRow = m, rightCol = n, leftCol = -1;
        while (ans.size() < m * n) {
            for (int i = topRow + 1, j = leftCol + 1; j < rightCol; j++) {
                ans.add(matrix[i][j]);
            }
            topRow++;
            if (ans.size() == m * n) break;

            for (int i = topRow + 1, j = rightCol - 1; i < botRow; i++) {
                ans.add(matrix[i][j]);
            }
            rightCol--;

            if (ans.size() == m * n) break;

            for (int i = botRow - 1, j = rightCol - 1; j > leftCol; j--) {
                ans.add(matrix[i][j]);
            }
            botRow--;
            if (ans.size() == m * n) break;

            for (int i = botRow - 1, j = leftCol + 1; i > topRow; i--) {
                ans.add(matrix[i][j]);
            }
            leftCol++;
            if (ans.size() == m * n) break;
        }
        return ans;
    }
}