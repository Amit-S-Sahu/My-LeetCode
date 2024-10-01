class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') ans.append((char)(ch + 32));
            else ans.append(ch);
        }
        return ans.toString();
    }
}