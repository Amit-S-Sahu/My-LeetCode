class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int ans = 0;
        int left = 0;
        for (int task[] : tasks) {
            if (left <= task[1]) ans += task[1] - left;
            left = Math.max(task[1] - task[0], left - task[0]);
        }
        return ans;
    }
}