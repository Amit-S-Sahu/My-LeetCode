class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int prefix[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            prefix[i][0] = (i == 0 ? 0 : prefix[i - 1][1]) + (ch == '1' ? 1 : 0);
            prefix[i][1] = (i == 0 ? 0 : prefix[i - 1][0]) + (ch == '0' ? 1 : 0);
        }

        int ans = Math.min(prefix[n - 1][0], prefix[n - 1][1]);
        if (n % 2 == 1) {
            int suffix[][] = new int[n][2];
            for (int i = n - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                suffix[i][0] = (i == n - 1 ? 0 : suffix[i + 1][1]) + (ch == '1' ? 1 : 0);
                suffix[i][1] = (i == n - 1 ? 0 : suffix[i + 1][0]) + (ch == '0' ? 1 : 0);
            }

            for (int i = 0; i < n - 1; i++) {
                ans = Math.min(ans, prefix[i][0] + suffix[i + 1][0]);
                ans = Math.min(ans, prefix[i][1] + suffix[i + 1][1]);
            }
        }

        return ans;
    }
}