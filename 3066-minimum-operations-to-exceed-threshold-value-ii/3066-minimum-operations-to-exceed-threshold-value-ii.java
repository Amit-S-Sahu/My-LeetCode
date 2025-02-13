class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((double) num);
        }

        int op = 0;
        while (pq.size() > 1) {
            double x = pq.poll();
            double y = pq.poll();
            if (x >= k) return op;
            double n = 2 * Math.min(x, y) + Math.max(x, y);
            pq.add(n);
            op++;
        }
        return op;
    }
}