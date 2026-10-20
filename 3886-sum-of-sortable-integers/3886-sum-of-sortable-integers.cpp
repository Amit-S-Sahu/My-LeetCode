class Solution {
public:
    int sortableIntegers(vector<int>& nums) {
        int n = nums.size();
        vector<int> temp(n);
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        sort(temp.begin(), temp.end());
        vector<int> div;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                div.push_back(i);
                if (i * i != n) div.push_back(n / i);
            }
        }

        long long sum = 0;
        for (auto num : div) {
            bool check = true;
            for (int i = 0; i < n; i += num) {
                vector<int> curr(num);
                vector<int> req(num);
                for (int j = 0; j < num; j++) {
                    curr[j] = nums[i + j];
                    req[j] = temp[i + j];
                }
                vector<int> currS(num);
                for (int k = 0; k < num; k++) {
                    currS[k] = curr[k];
                }
                sort(currS.begin(), currS.end());
                if (currS != req) {
                    check = false;
                    break;
                }
                int k = 0;
                for (int j = 0; j < num; j++) {
                    if (curr[j] > curr[(j + 1) % num]) k++;
                }
                if (k > 1) {
                    check = false;
                    break;
                }
            }
            if (check) sum += num;
        }
        return (int)sum;
    }
};