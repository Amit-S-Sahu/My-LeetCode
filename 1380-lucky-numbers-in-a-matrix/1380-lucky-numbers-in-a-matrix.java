class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) min = matrix[i][j];
            }
            set.add(min);
        }
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] > max) max = matrix[j][i];
            }
            if (set.contains(max)) list.add(max);
        }

        return list;
    }
}