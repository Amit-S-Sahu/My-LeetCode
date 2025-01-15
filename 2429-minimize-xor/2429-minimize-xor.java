class Solution {
    public int minimizeXor(int num1, int num2) {
        int temp1 = num1;
        int temp2 = num2;

        int setCount1 = 0;
        while (temp1 > 0) {
            setCount1 += temp1 & 1;
            temp1 >>= 1;
        }

        int setCount2 = 0;
        while (temp2 > 0) {
            setCount2 += temp2 & 1;
            temp2 >>= 1;
        }

        int ans = 0;
        if (setCount1 == setCount2) return num1;
        else if (setCount1 > setCount2) {
            int bitsToRemove = setCount1 - setCount2;
            for (int i = 0; i < 32; i++) {
                if ((num1 & (1 << i)) != 0) {
                    if (bitsToRemove > 0) bitsToRemove--;
                    else ans |= (1 << i);
                }
            }
        }
        else {
            int bitsToAdd = setCount2 - setCount1;
            ans = num1;
            for (int i = 0; i < 32 && bitsToAdd > 0; i++) {
                if ((ans & (1 << i)) == 0) {
                    ans |= (1 << i);
                    bitsToAdd--;
                }
            }
        }
        return ans;
    }
}