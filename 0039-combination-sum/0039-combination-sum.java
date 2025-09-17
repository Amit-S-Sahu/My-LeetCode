class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    private void helper(int candidates[], int sum, int target, int start) {
        if (sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            temp.add(candidates[i]);
            helper(candidates, sum + candidates[i], target, i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target, 0);
        return list;
    }
}