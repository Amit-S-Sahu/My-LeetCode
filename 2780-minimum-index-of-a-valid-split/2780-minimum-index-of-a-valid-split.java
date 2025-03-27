class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>(), left = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        for (int i = 0; i < nums.size() - 1; i++) {
            left.put(nums.get(i), left.getOrDefault(nums.get(i), 0) + 1);
            map.put(nums.get(i), map.get(nums.get(i)) - 1);
            
            if (left.get(nums.get(i)) * 2 > (i + 1) && map.get(nums.get(i)) * 2 > (nums.size() - i - 1))
                return i;
        }
        return -1;
    }
}