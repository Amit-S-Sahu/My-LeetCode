class Solution {
    public int minChanges(String s) {
        if (s.length() % 2 != 0) return 0;
        int same = 0;
        int diff = 0;
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) == s.charAt(i + 1)) same++;
            else diff++;
        }
        return diff;
    }
}