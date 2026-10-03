class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                st.pop();
                if (st.isEmpty()) st.push(i);
                else ans = Math.max(ans, i - st.peek());
            }
        }
        
        return ans;
    }
}