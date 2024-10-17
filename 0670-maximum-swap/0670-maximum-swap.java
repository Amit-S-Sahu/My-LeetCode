class Solution {
    public int maximumSwap(int num) {
        char number[] = Integer.toString(num).toCharArray();
        int digits[] = new int[10];
        for (int i = 0; i < number.length; i++) {
            digits[number[i] - '0'] = i;
        }

        for (int i = 0; i < number.length; i++) {
            for (int j = 9; j > number[i] - '0'; j--) {
                if (digits[j] > i) {
                    char temp = number[i];
                    number[i] = number[digits[j]];
                    number[digits[j]] = temp;
                    return Integer.parseInt(new String(number));
                }
            }
        }
        return num;
    }
}