class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) Collections.sort(list);
        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            List<Integer> curr = map.get(nums[query]);
            if (curr.size() < 2) {
                ans.add(-1);
                continue;
            }
            int i = Collections.binarySearch(curr, query);
            int left = curr.get((i - 1 + curr.size()) % curr.size());
            int right = curr.get((i + 1) % curr.size());
            int distLeft = Math.min(Math.abs(query - left), n - Math.abs(query - left));
            int distRight = Math.min(Math.abs(query - right), n - Math.abs(query - right));
            ans.add(Math.min(distLeft, distRight));
        }
        return ans;
    }
}