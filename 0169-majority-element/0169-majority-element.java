class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        System.out.println(3/2);
        for (int i = 0; i < (n / 2) + 1; i++) {
            if (map.get(nums[i]) > n / 2) return nums[i];
        }
        return -1;
    }
}