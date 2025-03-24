class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        for (int meeting[] : meetings) {
            if (merged.isEmpty() || meeting[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(meeting);
            } else {
                merged.get(merged.size() - 1)[1] = 
                    Math.max(merged.get(merged.size() - 1)[1], meeting[1]);
            }
        }

        int ans = 0;
        for (int m[] : merged) {
            ans += (m[1] - m[0] + 1);
        }

        return days - ans;
    }
}