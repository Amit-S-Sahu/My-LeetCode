class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    
    private void helper(int nums[], int i) {
        if (i == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        helper(nums, i + 1);
        temp.add(nums[i]);
        helper(nums, i + 1);
        temp.remove(temp.size() - 1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0);
        return new ArrayList<>(list);
    }
}
