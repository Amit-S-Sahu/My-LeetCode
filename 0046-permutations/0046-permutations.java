class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    private void helper(int nums[], boolean used[]) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            helper(nums, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new boolean[nums.length]);
        return list;
    }
}