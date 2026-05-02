class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int num = 1; num <= n; num++) {
            int temp = num;
            boolean valid = true;
            boolean changed = false;
            while (temp > 0 && valid) {
                int digit = temp % 10;
                if (digit == 3 || digit == 4 || digit == 7) valid = false;
                else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) changed = true;
                temp /= 10;
            }
            if (valid && changed) count++;
        }
        return count;
    }
}