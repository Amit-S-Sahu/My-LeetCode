class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder sb = new StringBuilder();
        int cycle = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycle) {
                sb.append(s.charAt(j));

                int k = j + cycle - 2 * i;
                if (i != 0 && i != numRows - 1 && k < s.length()) sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }
}
