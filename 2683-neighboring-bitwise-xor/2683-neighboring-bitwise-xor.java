class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int ans = 0;
        for (int num : derived) ans^= num;

        return ans == 0;
    }
}