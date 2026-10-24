class Solution {
public:
    int calculateDayOfYear(const string& day, const vector<int>& prefixSum) {
        int month = stoi(day.substr(0, 2));
        int date = stoi(day.substr(3));
        return prefixSum[month - 1] + date;
    }

    int countDaysTogether(string arriveAlice, string leaveAlice, string arriveBob, string leaveBob) {
        vector<int> days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        vector<int> prefixSum(1, 0);
        for (int date : days) {
            prefixSum.push_back(prefixSum.back() + date);
        }

        int aliceEntry = calculateDayOfYear(arriveAlice, prefixSum);
        int AliceExit = calculateDayOfYear(leaveAlice, prefixSum);
        int bobEntry = calculateDayOfYear(arriveBob, prefixSum);
        int bobExit = calculateDayOfYear(leaveBob, prefixSum);
        return max(0, min(AliceExit, bobExit) - max(aliceEntry, bobEntry) + 1);
    }
};