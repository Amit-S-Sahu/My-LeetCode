class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int ans[][] = new int[intervals.length][2];
        int k = 0;

        ans[0][0] = intervals[0][0];
        ans[0][1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int lastEnd = ans[k][1];

            if (intervals[i][0] > lastEnd) {
                k++;
                ans[k][0] = intervals[i][0];
                ans[k][1] = intervals[i][1];
            } 
            else ans[k][1] = Math.max(lastEnd, intervals[i][1]);
        }

        return Arrays.copyOfRange(ans, 0, k + 1);
    }
}
