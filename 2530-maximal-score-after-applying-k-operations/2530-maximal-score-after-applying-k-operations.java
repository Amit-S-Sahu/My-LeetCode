class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int num : nums) {
            pq.add(num);
        }
        
        long score = 0;
        while (k > 0) {
            int ele = pq.poll();  
            score += ele;
            pq.add((int) Math.ceil(ele / 3.0));  
            k--;
        }
        
        return score;
    }
}