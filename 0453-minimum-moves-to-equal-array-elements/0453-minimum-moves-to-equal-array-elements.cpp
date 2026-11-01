class Solution {
public:
    int minMoves(vector<int>& nums) {
        int n = nums.size();
        int _min = nums[0];
        for (auto num : nums) _min = min(_min, num);
        int ans = 0;
        for (int num : nums) ans += (num - _min);
        return ans;
    }
};