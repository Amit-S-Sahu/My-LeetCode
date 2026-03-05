class Solution {
    public int minOperations(String s) {
        int op1 = 0, op2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char temp1 = (i % 2 == 0) ? '0' : '1';
            char temp2 = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != temp1) op1++;
            if (s.charAt(i) != temp2) op2++;
        }

        return Math.min(op1, op2);
    }
}