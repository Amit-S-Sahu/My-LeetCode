import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i; j >= 1; j--) {
                if (dict.contains(s.substring(j - 1, i))) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
            }
        }
        return dp[s.length()];
    }
}