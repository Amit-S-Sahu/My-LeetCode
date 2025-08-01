class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    private void helper(int nums[], int sum, int start, int k , int n) {
        if (sum == n && temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, sum + nums[i], i + 1, k, n);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        helper(nums, 0, 0, k, n);
        return list;
    }
}