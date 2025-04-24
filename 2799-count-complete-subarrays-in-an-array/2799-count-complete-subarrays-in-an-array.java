class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int totalUnique = (int) Arrays.stream(nums).distinct().count();
        int n = nums.length, left = 0, res = 0, unique = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) unique++;

            while (unique == totalUnique) {
                res += n - right;
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) unique--;
                left++;
            }
        }
        return res;
    }
}