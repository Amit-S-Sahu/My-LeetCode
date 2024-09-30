class Solution {
    private int start = 0;
    private int end = 0;
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        helper(s.toCharArray(), 0);
        return s.substring(start, end + 1);
    }

    private void helper(char ch[], int i) {
        int n = ch.length;

        if (i > n - 1) return;

        int left = i, right = i;

        while (right < n - 1 && ch[right] == ch[right + 1]) right++;

        i = right;

        while (left > 0 && right < n - 1 && ch[left - 1] == ch[right + 1]) {
            left--;
            right++;
        }
        if (end - start < right - left) {
            start = left;
            end = right;
        }
        helper(ch, ++i);
    }
}