class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0, max = 0, min = 0;
        for (int x : differences) {
            sum += x;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return (int)Math.max(0, upper - lower - max + min + 1);
    }
}