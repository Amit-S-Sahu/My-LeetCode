class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        int n = s.length();
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 1; i < n; i++) {
            int curr = 0;

            if (s.charAt(i) != '0') curr += prev1;
            int two = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (two >= 10 && two <= 26) curr += prev2;

            if (curr == 0) return 0;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
