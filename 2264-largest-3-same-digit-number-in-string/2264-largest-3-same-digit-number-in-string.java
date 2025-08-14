class Solution {
    public String largestGoodInteger(String num) {
        if (num.length() < 3) return "";
        int max = -1;
        int count = 1;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                count++;
                if (count == 3) max = Math.max(max, num.charAt(i) - '0');
            }
            else count = 1;
        }

        return max == -1 ? "" : String.valueOf(max).repeat(3);
    }
}