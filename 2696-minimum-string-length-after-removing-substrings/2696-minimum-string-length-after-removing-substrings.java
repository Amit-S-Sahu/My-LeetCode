class Solution {
    public int minLength(String s) {
        if (s.length() == 1) return 1;
        int s1 = s.indexOf("AB");
        int s2 = s.indexOf("CD");
        if (s1 == -1 && s2 == -1) return s.length();
        if (s1 != -1) return minLength(s.substring(0, s1) + s.substring(s1 + 2));
        return minLength(s.substring(0, s2) + s.substring(s2 + 2));
    }
}