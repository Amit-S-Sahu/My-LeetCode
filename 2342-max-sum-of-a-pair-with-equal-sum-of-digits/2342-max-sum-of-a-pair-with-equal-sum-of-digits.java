class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int max = -1;

        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            int sum = 0;
            while (temp > 0) {
                sum += (temp % 10);
                temp /= 10;
            }
            map.putIfAbsent(sum, new PriorityQueue<>());
            map.get(sum).add(nums[i]);
            if (map.get(sum).size() > 2) map.get(sum).poll();
        }

        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() < 2) continue;
            int num1 = pq.poll();
            int num2 = pq.poll();
            max = Math.max(max, num1 + num2);
        }

        return max;
    }
}