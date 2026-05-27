class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int lastLow = word.lastIndexOf(c);
            int firstUp = word.indexOf(c - 'a' + 'A');
            if (lastLow == -1 || firstUp == -1) continue;
            if (firstUp > lastLow) ans++;
        }
        return ans;
    }
}