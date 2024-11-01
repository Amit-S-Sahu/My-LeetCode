class Solution {
    public String makeFancyString(String s) {
        if (s.length() <= 2) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == s.charAt(i - 1)) count++;
            else count = 1;

            if (count <= 2) sb.append(curr);
        }
        return sb.toString();
    }
}
