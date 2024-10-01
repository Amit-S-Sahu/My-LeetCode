class Solution {
    public int countSegments(String s) {
        String newS = s.trim().replaceAll("\\s+", " ");
        if (newS.length() == 0) return 0;
        else if (newS.length() == 1 && newS.charAt(0) == ' ') return 0;
        long count = newS.chars().filter(ch -> ch == ' ').count();
        return (int)count + 1;
    }
}