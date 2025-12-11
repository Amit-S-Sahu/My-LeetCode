class Solution {
    public int countCoveredBuildings(int num, int[][] buildings) {
        int n = buildings.length;
        if (n < 4) return 0;

        Map<Integer, int[]> col = new HashMap<>();
        Map<Integer, int[]> row = new HashMap<>();

        for (int building[] : buildings) {
            int x = building[0];
            int y = building[1];

            int c[] = col.get(x);
            if (c == null) col.put(x, new int[]{y, y});
            else {
                if (y < c[0]) c[0] = y;
                if (y > c[1]) c[1] = y;
            }

            int r[] = row.get(y);
            if (r == null) row.put(y, new int[]{x, x});
            else {
                if (x < r[0]) r[0] = x;
                if (x > r[1]) r[1] = x;
            }
        }

        int ans = 0;
        for (int building[] : buildings) {
            int x = building[0];
            int y = building[1];
            int c[] = col.get(x);
            int r[] = row.get(y);
            if (y > c[0] && y < c[1] && x > r[0] && x < r[1]) ans++;
        }

        return ans;
    }
}
