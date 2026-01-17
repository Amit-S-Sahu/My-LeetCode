class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;
    public SummaryRanges() {
        intervals = new TreeMap<>(); 
    }
    
    public void addNum(int value) {
        Map.Entry<Integer, Integer> min = intervals.floorEntry(value); 
        int left = value, right = value;
        if (min != null) {
            int prev = min.getValue();
            if (prev >= value) return;
            if (prev == value - 1) left = min.getKey();
        }
        Map.Entry<Integer, Integer> max = intervals.higherEntry(value); 
        if (max != null && max.getKey() == value + 1) {
            right = max.getValue();
            intervals.remove(value + 1);
        }
        intervals.put(left, right);
    }
    
    public int[][] getIntervals() {
        int ans[][] = new int[intervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            ans[i][0] = entry.getKey();
            ans[i++][1] = entry.getValue();
        }
        return ans; 
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */