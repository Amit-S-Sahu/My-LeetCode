class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        return doubled.indexOf(s, 1) != s.length();
    }
}