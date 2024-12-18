class Solution {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while (j < prices.length && prices[j] > prices[i]) j++;
            if (j >= prices.length) continue;
            prices[i] -= prices[j];
        }

        return prices;
    }
}