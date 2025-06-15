class Solution {
    private int createHigh(int num, int st) {
        int high = 0, mp1 = -1;
        while (st > 0) {
            int dig = num / st;
            if (mp1 == -1 && dig != 9) mp1 = dig;            
            if (dig == mp1) high = high * 10 + 9;
            else high = high * 10 + dig;
            num %= st;
            st /= 10;
        }
        return high;
    }

    private int createLow(int num, int st) {
        int low = 0, mp1 = -1, isFirstOne = 0;
        while (st > 0) {
            int dig = num / st;
            if (isFirstOne == 0) {
                if (dig == 1) isFirstOne = 1;
                else isFirstOne = -1;
            }
            if (dig != 1 && mp1 == -1 && dig != 0) mp1 = dig;
            if (dig == mp1) low = low * 10 + (isFirstOne == 1 ? 0 : 1);
            else low = low * 10 + dig;

            num %= st;
            st /= 10;
        }

        return low;
    }

    public int maxDiff(int num) {
        int dig = (int) Math.log10(num) + 1;
        int st = (int) Math.pow(10, dig - 1);
        return createHigh(num, st) - createLow(num, st);
    }
}