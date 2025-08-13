class Solution {
    public boolean isPowerOfThree(int n) {
        while (n >= 1) {
            if (n == 1) return true;
            if (n % 3 != 0) return false;
            n /= 3; 
        }
        return false;
    }
}