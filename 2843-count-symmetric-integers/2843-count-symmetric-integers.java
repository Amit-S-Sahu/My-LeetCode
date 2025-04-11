class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            String str = Integer.toString(num);
            int n = str.length();

            if ((n & 1) == 1) continue;
            int half = n / 2;
            int left = 0;
            int right = 0;

            for (int i = 0; i < half; i++) left += str.charAt(i) - '0';
            for (int i = half; i < n; i++) right += str.charAt(i) - '0';

            if (left == right) count++;
        }

        return count;
    }
}