class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (j < s.length() && i < spaces.length) {
            if (j != spaces[i]) {
                ans.append(s.charAt(j));
                j++;
                continue;
            }

            ans.append(' ');
            i++;
        }

        while (j < s.length()) {
            ans.append(s.charAt(j));
            j++;
        }

        return ans.toString();
    }
}