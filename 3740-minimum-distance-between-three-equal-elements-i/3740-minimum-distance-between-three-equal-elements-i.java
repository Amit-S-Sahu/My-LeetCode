class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int min = Integer.MAX_VALUE;
        System.out.println(map);
        for (List<Integer> num : map.values()) {
            if (num.size() >= 3) {
                for (int i = 1; i < num.size() - 1; i++) {
                    min = Math.min(min, (Math.abs(num.get(i) - num.get(i - 1)) + Math.abs(num.get(i - 1) - num.get(i + 1)) + Math.abs(num.get(i) - num.get(i + 1))));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}