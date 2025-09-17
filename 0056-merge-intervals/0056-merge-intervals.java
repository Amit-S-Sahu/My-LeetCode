class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int num = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
                intervals[i - 1][0] = -1;
                num--;
            }
        }

        int res[][] = new int[num][2];
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == -1) continue;
            res[j][0] = intervals[i][0];
            res[j][1] = intervals[i][1];
            j++;
        }
        return res;
    }
}