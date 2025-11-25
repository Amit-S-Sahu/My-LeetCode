class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        String sr = new StringBuilder(s).reverse().toString();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sr.charAt(i)) ans++;
        }

        return ans;
    }
}