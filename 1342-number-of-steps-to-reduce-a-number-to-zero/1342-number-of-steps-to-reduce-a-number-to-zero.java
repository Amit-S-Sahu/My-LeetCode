class Solution {
    private static int helper(int num, int count) {
        if (num == 0) return count;
        return (num & 1) == 0 ? helper(num / 2, count + 1) : helper(num - 1, count + 1);
    }
    
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }
}