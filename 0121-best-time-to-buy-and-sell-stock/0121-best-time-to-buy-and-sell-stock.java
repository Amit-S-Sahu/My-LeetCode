class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int n = prices.length;
        int rightMax[] = new int[n];
        rightMax[n - 1] = 0;
        int currmax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (currmax > prices[i]) {
                rightMax[i] = currmax;
            }
            else {
                rightMax[i] = 0;
                currmax = prices[i];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, rightMax[i] - prices[i]);
        }
        return max;
    }
}