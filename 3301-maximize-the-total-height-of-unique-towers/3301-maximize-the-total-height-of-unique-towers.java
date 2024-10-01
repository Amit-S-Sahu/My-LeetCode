class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int len = maximumHeight.length;
        Arrays.sort(maximumHeight);
        long sum = 0;
        long curr = maximumHeight[len - 1];

        for (int i = len - 1; i >= 0; i--) {
            curr = Math.min(curr, maximumHeight[i]);
            if (curr <= 0) return -1;
            sum += curr;
            curr--;
        }
        return (long)sum;
    }
}