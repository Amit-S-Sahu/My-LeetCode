class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int coords[] = new int[2];
                coords[0] = i;
                coords[1] = j;
                map.put(mat[i][j], coords);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int coords[] = map.get(arr[i]);
            int r = coords[0];
            int c = coords[1];

            row[r]++;
            col[c]++;

            if (row[r] == mat[0].length || col[c] == mat.length) return i;
        }

        return 1;
    }
}