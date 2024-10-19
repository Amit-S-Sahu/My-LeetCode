class Solution {
    StringBuilder ans = new StringBuilder("0");
    private StringBuilder invertAndReverse(StringBuilder sb) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char curr = sb.charAt(i);
            if (curr == '0') temp.append("1");
            else temp.append("0");
        }
        return temp.reverse();
    }

    public char findKthBit(int n, int k) {
        if (ans.length() >= k) return ans.charAt(k - 1);
        if (n <= 1) return ans.charAt(k - 1);
        StringBuilder temp = invertAndReverse(ans);
        ans.append("1").append(temp);
        return findKthBit(n - 1, k);
    }
}