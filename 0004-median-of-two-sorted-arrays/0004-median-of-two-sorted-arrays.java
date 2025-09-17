class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums1) {
            if (max.isEmpty() || num <= max.peek()) max.offer(num);
            else min.offer(num);

            if (max.size() > min.size() + 1) min.offer(max.poll());
            else if (min.size() > max.size()) max.offer(min.poll()); 
        }

        for (int num : nums2) {
            if (max.isEmpty() || num <= max.peek()) max.offer(num);
            else min.offer(num);

            if (max.size() > min.size() + 1) min.offer(max.poll());
            else if (min.size() > max.size()) max.offer(min.poll()); 
        }   

        return (max.size() > min.size()) ? max.peek() : ((long)max.peek() + (long)min.peek()) / 2.0;
    }
}