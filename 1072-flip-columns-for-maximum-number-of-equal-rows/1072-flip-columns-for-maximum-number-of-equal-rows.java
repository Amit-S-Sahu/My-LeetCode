class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> freq = new HashMap<>();
        
        for (int row[] : mat) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } 
            else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            freq.merge(pattern.toString(), 1, Integer::sum);
        }
        
        return Collections.max(freq.values());
    }
}