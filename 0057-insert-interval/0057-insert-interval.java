import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        
        int newGroup[][] = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            newGroup[i] = intervals[i];
        }
        newGroup[n] = newInterval;

        Arrays.sort(newGroup, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> list = new ArrayList<>();
        int current[] = newGroup[0];

        for (int i = 1; i < n + 1; i++) {
            if (current[1] >= newGroup[i][0]) current[1] = Math.max(current[1], newGroup[i][1]);
            else {
                list.add(current);
                current = newGroup[i];
            }
        }
        list.add(current);

        return list.toArray(new int[list.size()][]);
    }

}
