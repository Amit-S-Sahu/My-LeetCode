class Solution {
public:
    int maxSum(vector<int>& nums, int k) {
        const int MOD = 1e9 + 7;
        vector<int> count(30, 0);

        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if (num & (1 << i)) {
                    count[i]++;
                }
            }
        }

        long long ans = 0;
        for (int i = 0; i < k; i++) {
            long long cur = 0;
            for (int j = 29; j >= 0; j--) {
                if (count[j] > 0) {
                    cur |= (1LL << j);
                    count[j]--;
                }
            }
            ans = (ans + cur * cur) % MOD;
        }

        return (int)ans;
    }
};