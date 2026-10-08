class Solution {
public:
    string removeOuterParentheses(string s) {
        string ans;
        stack<char> st;
        for (auto ch : s) {
            if (ch == ')') st.pop();
            if (!st.empty()) ans.push_back(ch);
            if (ch == '(') st.emplace(ch);
        }
        return ans;
    }
};