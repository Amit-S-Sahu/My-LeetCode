class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char reqd = strs[0].charAt(i);
            int flag = 0;
            for (String s : strs) {
                if (s.length() <= i) {
                    flag = 1;
                    break;
                }
                if (s.charAt(i) != reqd) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) return ans.toString();
            else ans.append(reqd);
        }

        return ans.toString();
    }
}