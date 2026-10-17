class Solution {
public:
    int minSwaps(vector<int>& nums) {
        int n = nums.size();
        vector<int> sums(n);

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;
            while (num > 0) {
                sum += (num % 10);
                num /= 10;
            }
            sums[i] = sum;
        }

        vector<int> idx(n);
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        sort(idx.begin(), idx.end(), [&](int a, int b) {
            if (sums[a] != sums[b]) return sums[a] < sums[b];
            return nums[a] < nums[b];
        });

        vector<int> tarPos(n);
        for (int i = 0; i < n; i++) {
            tarPos[idx[i]] = i;
        }

        vector<bool> visited(n);
        int cycle = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            cycle++;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = tarPos[j];
            }
        }
        return n - cycle;
    }
};