class Solution {
    public long minEnd(int n, int x) {
        long ans = x;
        long i = 1;
        n--;
        
        while (n != 0) {
            if ((x & i) == 0) {
                ans |= (n & 1) * i;
                n >>= 1;
            }
            i <<= 1;
        }
        
        return ans;
    }
}