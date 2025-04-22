class Solution {
    public int idealArrays(int n, int m) {
        int MOD = (int)1e9 + 7;
        long dp[][] = new long[m + 1][15];

        for(int i = 1; i <= m; i++) dp[i][1] = 1;
        
        for(int j = 1; j < 14; j++) {
            for(int i = 1; i <= m; i++) {
                for(int k = 2; i * k <= m; k++) {
                    dp[k * i][j + 1] = (dp[i][j] + dp[k * i][j + 1]) % MOD;
                }
            }
        }
        
        
        long comb[][] = new long[n][15];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 15 && j <= i; j++){
                if(j == 0) comb[i][j] = 1;
                else comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        
        long res = 0L;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= 14 && j <= n; j++){
                res = (res + dp[i][j] * comb[n - 1][j - 1]) % MOD;
            }
        }
        return (int)res;
    }
}