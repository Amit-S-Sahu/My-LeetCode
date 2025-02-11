class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int n = part.length();
        while (sb.toString().contains(part)) {
            int i = sb.toString().indexOf(part);
            sb.delete(i, i + n);
            System.out.println(sb);
        }

        return sb.toString();
    }
}