class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        char c1 = '\0', c2 = '\0';
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 3) return false;
                if (count == 1) {
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                }
                else if (count == 2) {
                    if (s1.charAt(i) != c2 || s2.charAt(i) != c1) return false;
                }
            }
        }

        return count == 0 || count == 2;
    }
}