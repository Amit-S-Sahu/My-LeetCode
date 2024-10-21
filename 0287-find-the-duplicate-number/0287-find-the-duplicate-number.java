class Solution {
    public int findDuplicate(int[] nums) {
        int count[] = new int[nums.length];
        for (int num: nums) {
            if (count[num] == 0) count[num]++;
            else return num;
        }

        return -1;
    }
}