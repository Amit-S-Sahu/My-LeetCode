class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (String.valueOf(i).indexOf('0') < 0 && String.valueOf(n - i).indexOf('0') < 0) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{-1, -1};
    }
}