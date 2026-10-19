class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        auto lower = [&]() {
            int left = 0;
            int right = nums.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) left = mid + 1;
                else right = mid;
            }
            return left;
        };
        auto upper = [&]() {
            int left = 0;
            int right = nums.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) left = mid + 1;
                else right = mid;
            }
            return left;
        };

        vector<int> ans;
        int i = lower();
        int j = upper();
        for (; i < j; i++) {
            ans.push_back(i);
        }
        return ans;
    }
};