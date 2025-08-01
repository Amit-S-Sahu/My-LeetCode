class Solution {
    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        int mod = 1_000_000_007;
        long numEvens = (n + 1) / 2;
        long numPrimes = n / 2;
        long result = (modPow(5, numEvens, mod) * modPow(4, numPrimes, mod)) % mod;
        return (int) result;
    }
}
