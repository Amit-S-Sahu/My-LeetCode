class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int j = binarySearch(potions, spells[i], success);
            if (j != -1) ans[i] = potions.length - j;
        }

        return ans;
    }

    int binarySearch(int potions[], long strength, long success) {
        int low = 0, high = potions.length - 1, i = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) potions[mid] * strength >= success) {
                i = mid;
                high = mid - 1; 
            } 
            else low = mid + 1;
        }
        return i;
    }
}