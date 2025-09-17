class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) pq.offer(num);
        while (!pq.isEmpty() && k > 1) {
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}