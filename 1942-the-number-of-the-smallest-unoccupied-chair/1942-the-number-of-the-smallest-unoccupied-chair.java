class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int next = 0;
        int target = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> left = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> avail = new PriorityQueue<>();

        for (int time[] : times) {
            int start = time[0], leave = time[1];

            while (!left.isEmpty() && left.peek()[0] <= start) {
                avail.add(left.poll()[1]);
            }

            int sat;
            if (!avail.isEmpty()) sat = avail.poll();
            else sat = next++;

            left.add(new int[]{leave, sat});

            if (start == target) return sat;
        }
        return -1; 
    }
}