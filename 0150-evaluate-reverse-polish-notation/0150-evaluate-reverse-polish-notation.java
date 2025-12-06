class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Long> st = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                long a = st.pop();
                long b = st.pop();
                st.push(a + b);
            }
            else if (token.equals("-")) {
                long b = st.pop();
                long a = st.pop();
                st.push(a - b);
            }
            else if (token.equals("*")) {
                long a = st.pop();
                long b = st.pop();
                st.push(a * b);
            }
            else if (token.equals("/")) {
                long b = st.pop();
                long a = st.pop();
                st.push((long)Math.floor(a / b));
            }
            else st.push(Long.parseLong(token));
        }
        long ans = st.pop();
        return (int)ans;
    }
}