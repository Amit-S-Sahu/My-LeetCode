class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        int n = nums.size();
        long long ans = 0;
        priority_queue<int> pq;
        for (auto num : nums) {
            pq.push(abs(num));
        }
        for (int i = 0; i < ((n + 1) / 2); i++) {
            int num = pq.top();
            ans += num * num;
            pq.pop();
        }
        while (!pq.empty()) {
            int num = pq.top();
            ans -= num * num;
            pq.pop();
        }
        return ans;
    }
};