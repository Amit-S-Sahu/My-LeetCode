class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == max) count++;
        }

        return count * max;
    }
}