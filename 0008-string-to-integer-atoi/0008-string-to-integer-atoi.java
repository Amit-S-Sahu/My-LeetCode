class Solution {
    public int myAtoi(String s) {
        String newS = s.trim();
        if (newS.length() == 0) return 0;
        int ans = 0, i = 0;

        int flag = 1;
        if (newS.charAt(i) == '-') {
            flag = -1; 
            i++;
        } else if (newS.charAt(i) == '+') {
            i++; 
        }

        for (; i < newS.length(); i++) {
            char curr = newS.charAt(i);
            if (curr < '0' || curr > '9') break; 

            if (ans > (Integer.MAX_VALUE - (curr - '0')) / 10) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = (ans * 10) + (curr - '0');
        }

        return ans * flag;
    }
}