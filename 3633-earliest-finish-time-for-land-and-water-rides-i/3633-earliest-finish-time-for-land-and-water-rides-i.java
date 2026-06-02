class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int land = landStartTime[i] + landDuration[i];
                int landWater = Math.max(land, waterStartTime[j]) + waterDuration[j];
                ans = Math.min(ans, landWater);
                int water = waterStartTime[j] + waterDuration[j];
                int waterLand = Math.max(water, landStartTime[i]) + landDuration[i];
                ans = Math.min(ans, waterLand);
            }
        }
        return ans;
    }
}