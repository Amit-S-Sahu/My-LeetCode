class Solution {
    public int compress(char[] chars) {
        int count = 1;
        StringBuilder ans = new StringBuilder();
        ans.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count += 1;
            }
            else {
                if (count > 1) ans.append(String.valueOf(count));
                ans.append(chars[i]);
                count = 1;
            }
        }
        if (count > 1) ans.append(String.valueOf(count));

        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }

        return ans.length();
    }
}