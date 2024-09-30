class Solution {
    public String reverseVowels(String s) {
        StringBuilder temp = new StringBuilder(s);
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            char ch_l = temp.charAt(left);
            char ch_r = temp.charAt(right);

            if (((ch_l == 'a') || (ch_l == 'A') || (ch_l == 'e') || (ch_l == 'E') || (ch_l == 'i') || (ch_l == 'I') || (ch_l == 'o') || (ch_l == 'O') || (ch_l == 'u') || (ch_l == 'U')) && ((ch_r == 'a') || (ch_r == 'A') || (ch_r == 'e') || (ch_r == 'E') || (ch_r == 'i') || (ch_r == 'I') || (ch_r == 'o') || (ch_r == 'O') || (ch_r == 'u') || (ch_r == 'U'))) {
                temp.setCharAt(left, ch_r); 
                temp.setCharAt(right, ch_l);
                left++;
                right--;
            } else if ((ch_l == 'a') || (ch_l == 'A') || (ch_l == 'e') || (ch_l == 'E') || (ch_l == 'i') || (ch_l == 'I') || (ch_l == 'o') || (ch_l == 'O') || (ch_l == 'u') || (ch_l == 'U')) {
                right--;
            } else {
                left++;
            }
        }

        return temp.toString();
    }
}