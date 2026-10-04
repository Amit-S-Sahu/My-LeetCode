class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int close = 0;
        int n = s.length() - 1;

        for (int i = 0; i <= n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') open++;
            else open--;

            if (s.charAt(n - i) == ')' || s.charAt(n - i) == '*') close++;
            else close--;

            if (open < 0 || close < 0) return false;
        }

        return true;
    }
}