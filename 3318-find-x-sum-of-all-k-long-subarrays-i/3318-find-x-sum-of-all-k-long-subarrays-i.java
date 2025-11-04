class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        ans[0] = calculateXSum(map, x);
        
        for (int i = 1; i <= n - k; i++) {
            int left = nums[i - 1];
            map.put(left, map.get(left) - 1);
            if (map.get(left) == 0) {
                map.remove(left);
            }

            int new_elem = nums[i + k - 1];
            map.put(new_elem, map.getOrDefault(new_elem, 0) + 1);

            ans[i] = calculateXSum(map, x);
        }
        
        return ans;
    }

    private int calculateXSum(Map<Integer, Integer> map, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (a[1] == b[1]) ? (b[0] - a[0]) : (b[1] - a[1])
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int sum = 0;
        for (int i = 0; i < x && !maxHeap.isEmpty(); i++) {
            int[] top = maxHeap.poll();
            sum += top[0] * top[1];
        }
        return sum;
    }
}
