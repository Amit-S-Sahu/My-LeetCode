class Solution {
    public int maximumGain(String s, int x, int y) {
        String s1 = x >= y ? "ab" : "ba";
        String s2 = x >= y ? "ba" : "ab";
        int i = Math.max(x, y);
        int j = Math.min(x, y);

        int total = 0;
        StringBuilder res = new StringBuilder();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == s1.charAt(0) && c == s1.charAt(1)) {
                stack.pop();
                total += i;
            } 
            else stack.push(c);
        }

        while (!stack.isEmpty()) res.append(stack.pollLast());

        stack.clear();
        for (char c : res.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == s2.charAt(0) && c == s2.charAt(1)) {
                stack.pop();
                total += j;
            } 
            else stack.push(c);
        }

        return total;
    }
}
