class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int x[][] = new int[rectangles.length][2];
        int y[][] = new int[rectangles.length][2];

        for (int i = 0; i < rectangles.length; i++) {
            x[i][0] = rectangles[i][0];
            x[i][1] = rectangles[i][2];
            y[i][0] = rectangles[i][1];
            y[i][1] = rectangles[i][3];
        }

        return check(x) || check(y);
    }

    private boolean check(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int sections = 0;
        int max = intervals[0][1];

        for (int interval[] : intervals) {
            if (max <= interval[0]) sections++;
            max = Math.max(max, interval[1]);
        }

        return sections >= 2;
    }
}