class Solution {
    public int numWays(String[] words, String target) {
        int n = words.length;
        int m = words[0].length();
        int mod = 1_000_000_007;
        int chars[][] = new int[m][26];
        for (String word : words) {
            for (int j = 0; j < m; j++) {
                chars[j][word.charAt(j) - 'a']++;
            }
        }
        int dp[][] = new int[m][target.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, target, chars, dp, mod);
    }
    public int helper(int i, int j, String target, int[][] chars, int[][] dp, int mod) {
        if (j == target.length()) return 1;
        if (i == chars.length) return 0; 
        if (dp[i][j] != -1) return dp[i][j]; 

        long count = helper(i + 1, j, target, chars, dp, mod); 
        count %= mod;
        count += (1L * chars[i][target.charAt(j) - 'a'] * helper(i + 1, j + 1, target, chars, dp, mod)) % mod;
        count %= mod;
        return dp[i][j] = (int) count;
    }
}