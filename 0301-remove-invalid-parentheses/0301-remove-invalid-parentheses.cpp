class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        vector<string> ans;

        function<void(string, int, int)> bw = [&](string st, int right_i, int right_j) {
            int curr = 0;
            for (int i = right_i; i >= 0; i--) {
                curr += (st[i] == ')') - (st[i] == '(');
                if (curr >= 0) continue;
                for (int j = right_j; j >= i; j--) {
                    if ((st[j] == '(') && (j == right_j || st[j + 1] != '(')) {
                        bw(st.substr(0, j) + st.substr(j + 1), i - 1, j - 1);
                    }
                }
                return;
            }
            ans.push_back(st);
        };

        function<void(string, int, int)> fw = [&](string st, int left_i, int left_j) {
            int curr = 0;
            for (int i = left_i; i < st.length(); i++) {
                curr += (st[i] == '(') - (st[i] == ')');
                if (curr >= 0) continue;
                for (int j = left_j; j <= i; j++) {
                    if ((st[j] == ')') && (j == left_j || st[j - 1] != ')')) {
                        fw(st.substr(0, j) + st.substr(j + 1), i, j);
                    }
                }
                return;
            }
            bw(st, st.length() - 1, st.length() - 1);
        };

        fw(s, 0, 0);

        return ans;
    }
};