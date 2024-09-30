class Solution {
    private int getNum(long num1, long num2, long n) {
        int gap = 0;
        while (num1 <= n) {
            gap += Math.min(n + 1, num2) - num1;
            num1 *= 10;
            num2 *= 10;
        }
        return gap;
    }

    public int findKthNumber(int n, int k) {
        long num = 1;
        int i = 1; 
        while (i < k) {
            int req = getNum(num, num + 1, n);
            if (i + req <= k) {
                i += req;
                num++;
            } else {
                i++;
                num *= 10;
            }
        }
        return (int)num;
    }
}