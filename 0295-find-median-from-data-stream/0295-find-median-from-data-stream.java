class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek()) max.offer(num);
        else min.offer(num);

        if (max.size() > min.size() + 1) min.offer(max.poll());
        else if (min.size() > max.size()) max.offer(min.poll());
    }
    
    public double findMedian() {
        return (max.size() > min.size()) ? max.peek() : ((long)max.peek() + (long)min.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */