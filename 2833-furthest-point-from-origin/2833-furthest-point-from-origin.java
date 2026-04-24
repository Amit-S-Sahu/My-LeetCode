class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, none = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') left++;
            else if (ch == 'R') right++;
            else none++;
        }
        return Math.abs(left - right) + none;
    }
}