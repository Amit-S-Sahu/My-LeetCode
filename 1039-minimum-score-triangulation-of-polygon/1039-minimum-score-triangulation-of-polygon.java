class Solution {
    public int minScoreTriangulation(int[] values) {
        Arrays.sort(values);
        int n = values.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int curr = values[i];
            for (int j = i + 1; j < n; j++) {
                curr *= values[j];
                for (int k = j + 1; k < n; k++) {
                    curr *= values[k];
                    sum += curr;
                    curr /= values[k];
                }
                return sum;
            }
        }
        return sum;
    }
}