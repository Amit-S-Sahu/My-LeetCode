class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        
        int start = 0;     
        for (int end = 1; end <= n; end++) {
            if (end == n || nums[end] != nums[end - 1] + 1) {
                if (start == end - 1) ans.add(String.valueOf(nums[start]));
                else ans.add(nums[start] + "->" + nums[end - 1]);
                start = end;  
            }
        }  
        return ans;
    }
}