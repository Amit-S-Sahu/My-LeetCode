class Solution {
public:
    int minMoves(vector<int>& nums) {
        int _max = nums[0];
        for (auto num : nums) _max = max(_max, num);
        int ans = 0;
        for (auto num : nums) ans += (_max - num);
        return ans; 
    }
};