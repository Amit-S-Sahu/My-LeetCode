class Solution {
public:
    int minOperations(string s) {
        int n = s.size();
        bool check = true;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] > s[i + 1]) {
                check = false;
                break;
            }
        }
        if (check) return 0;
        if (n == 2) return -1;
        char min = s[0];
        char max = s[0];
        int minC = 0, maxC = 0;

        for (int i = 0; i < n; i++) {
            char ch = s[i];
            if (ch < min) min = ch;
            if (ch > max) max = ch;
        }

        for (int i = 0; i < n; i++) {
            char ch = s[i];
            if (ch == min) minC++;
            if (ch == max) maxC++;
        }

        if (s[0] == min || s[n - 1] == max) return 1;
        if (s[0] == max && maxC == 1 && s[n - 1] == min && minC == 1) return 3;

        return 2;
    }
};