class Solution {
    public int totalMoney(int n) {
        int start = 1, total = 0;
        while (n > 0) {
            for (int day = start; day < start + 7 && n > 0; ++day) {
                total += day;
                n--;
            }
            start++;
        }
        return total;
    }
}