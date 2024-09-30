class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        if (digits[n] == 9) {
            while (n > 0 && digits[n] == 9) {
                digits[n--] = 0;
            }
        }
        if (digits[n] == 9) {
            int newDigits[] = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = 0;
            }
            return newDigits;
        }
        else {
            digits[n] += 1;
        }
        return digits;
    }
}