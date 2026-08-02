class Solution {
    long MOD = (long)1e9 + 7;

    private long modPow(long a, long b) {
        if (b == 0) return 1;
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans = (ans * (a % MOD)) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }

    public int countGoodNumbers(long n) {
        long ans;
        if ((n & 1) == 0) ans = ((modPow(5, n / 2) % MOD) * (modPow(4, n / 2) % MOD)) % MOD;
        else ans = ((modPow(5, (n / 2) + 1) % MOD) * (modPow(4, n / 2) % MOD)) % MOD;
        return (int)ans;
    }
}