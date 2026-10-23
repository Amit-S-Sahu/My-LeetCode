class Solution {
public:
    int sortPermutation(vector<int>& nums) {
        int n = nums.size();

        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) ans &= i;
        }
        return ans == INT_MAX ? 0 : ans;
    }
};