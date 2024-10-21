class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newIntervals[][] = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);
        newIntervals[intervals.length][0] = newInterval[0];
        newIntervals[intervals.length][1] = newInterval[1];
        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));

        int ans[][] = new int[newIntervals.length][2];
        int k = 0;

        ans[0][0] = newIntervals[0][0];
        ans[0][1] = newIntervals[0][1];

        for (int i = 1; i < newIntervals.length; i++) {
            int lastEnd = ans[k][1];

            if (newIntervals[i][0] > lastEnd) {
                k++;
                ans[k][0] = newIntervals[i][0];
                ans[k][1] = newIntervals[i][1];
            } 
            else ans[k][1] = Math.max(lastEnd, newIntervals[i][1]);
        }
        return Arrays.copyOfRange(ans, 0, k + 1);
    }
}