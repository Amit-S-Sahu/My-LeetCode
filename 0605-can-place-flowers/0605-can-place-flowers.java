class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == (flowerbed.length - 1) || (flowerbed[i] == flowerbed[i+1])) {
                    --n;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}