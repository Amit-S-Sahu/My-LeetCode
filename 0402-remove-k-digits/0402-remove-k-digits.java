class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        ArrayDeque<Integer> s = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            int temp = ch - '0';
            while (!s.isEmpty() && k > 0 && temp < s.peek()) {
                s.pop();
                k--;
            }
            s.push(temp);
        }
        while (k > 0) {
            s.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while (!s.isEmpty()) {
            ans.append(Integer.valueOf(s.pop()));
        }
        ans = ans.reverse();
        while (ans.length() > 1 && ans.charAt(0) == '0') ans.deleteCharAt(0);
        return ans.toString();
    }
}