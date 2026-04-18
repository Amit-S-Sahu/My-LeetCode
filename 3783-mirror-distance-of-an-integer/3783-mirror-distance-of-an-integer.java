class Solution {
    private int reverse(int n) {
        int temp = 0;
        while (n > 0) {
            temp = temp * 10 + n % 10;
            n /= 10;
        }
        return temp;
    }
    
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
}