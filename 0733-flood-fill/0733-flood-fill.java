class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int start = image[sr][sc];
        if (start == color) return image;
        Deque<int[]> q = new ArrayDeque<>();
        int dirX[] = {-1, 1, 0, 0};
        int dirY[] = {0, 0, 1, -1};
        q.addLast(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int curr[] = q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dirX[i];
                int ny = curr[1] + dirY[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (image[nx][ny] == start) {
                    image[nx][ny] = color;
                    q.addLast(new int[]{nx, ny});
                }
            }
        }
        return image;
    }
}