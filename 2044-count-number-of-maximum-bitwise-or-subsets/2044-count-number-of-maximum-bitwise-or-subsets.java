class Solution {
    List<Integer> or = new ArrayList<>();
    public int countMaxOrSubsets(int[] nums) {
        helper(0, nums, 0);
        Collections.sort(or, Collections.reverseOrder());
        int max = or.get(0);
        int ans = 0;
        for (Integer i: or){
            if (max == i) ans++;
            else break;
        }
        return ans;
    }
    public void helper(int index,int[] nums,int sum){
        if (index == nums.length){
            or.add(sum);
            return;
        }
        int val = (sum | nums[index]);
        helper(index+1,nums,val);
        helper(index+1,nums,sum);
    }
}