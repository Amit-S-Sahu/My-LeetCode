class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        char grid[][] = new char[rows][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = encodedText.charAt(k);
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            int j = 0;
            k = i;
            while (j < rows && k < cols) {
                sb.append(grid[j++][k++]);
            }
        }
        return sb.toString().stripTrailing();
    }
}