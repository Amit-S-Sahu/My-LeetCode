class Solution {
public:
    int scoreOfParentheses(string s) {
        stack<int> st;
        st.push(0);
        for (auto ch : s) {
            if (ch == '(') st.push(0);
            else {
                int a = st.top();
                st.pop();
                int b = st.top();
                st.pop();
                st.push(b + max(2 * a, 1));
            }
        }
        return st.top();
    }
};