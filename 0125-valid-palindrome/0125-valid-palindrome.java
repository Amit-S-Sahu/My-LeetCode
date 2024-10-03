class Solution {

    public boolean isPalindrome(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= '0' && curr <= '9') {
                ans.append(curr);
            }
            else if (curr >= 'a' && curr <= 'z') {
                ans.append(curr);
            }
            else if(curr >= 'A' && curr <= 'Z') {
                ans.append((char)(curr + 32));
            }
        }
        System.out.println(ans);

        if (ans.length() <= 1) return true;

        int left = 0, right = ans.length() - 1;

        while (left < right) {
            if (ans.charAt(left) != ans.charAt(right)) return false;
            left++;
            right--;
        } 
        return true;  
    }
}