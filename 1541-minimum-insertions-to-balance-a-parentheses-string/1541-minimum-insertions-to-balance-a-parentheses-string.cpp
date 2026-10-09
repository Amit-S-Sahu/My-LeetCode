class Solution {
public:
    int minInsertions(string s) {
        int n = s.size();
        int ans = 0;
        int left = 0;
        int i = 0;
        while (i < n) {
            char c = s[i];
            if (c == '(') {
                left++;
                i++;
            } 
            else {
                if (left > 0) left--;
                else ans++;

                if (i < n - 1 && s[i + 1] == ')') i += 2;
                else {
                    ans++;
                    i++;
                }
            }
        }
        ans += left * 2;
        return ans;
    }
};