class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;

        for (char letter : s.toCharArray()) c ^= letter;
        for (char letter : t.toCharArray()) c ^= letter;

        return c;
    }
}