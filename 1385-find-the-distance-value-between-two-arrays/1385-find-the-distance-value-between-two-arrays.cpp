class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        int ans = 0;
        for (auto num1 : arr1) {
            bool check = true;
            for (auto num2 : arr2) {
                check &= (abs(num1 - num2) > d);
            }
            ans += check;
        }
        return ans;
    }
};