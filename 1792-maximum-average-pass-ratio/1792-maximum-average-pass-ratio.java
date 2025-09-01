class Solution {
    private double gain(int cls[]) {
        return (double)(cls[0] + 1) / (cls[1] + 1) - (double)cls[0] / cls[1];
    }
    
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(gain(b), gain(a))
        );

        for (int cls[] : classes) pq.add(cls);

        while (extraStudents-- > 0) {
            int cls[] = pq.poll();
            cls[0]++; cls[1]++;
            pq.add(cls);
        }

        double sum = 0;
        for (int cls[] : pq) sum += (double)cls[0] / cls[1];
        return sum / classes.length;
    }
}
