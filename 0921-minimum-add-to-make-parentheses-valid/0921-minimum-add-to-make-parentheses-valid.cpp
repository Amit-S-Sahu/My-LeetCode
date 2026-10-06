class Solution {
public:
    int minAddToMakeValid(string s) {
        stack<int> st;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') st.push(0);
            else if (!st.empty() && st.top() == 0) st.pop();
            else st.push(1);
        }
        return st.size();
    }
};