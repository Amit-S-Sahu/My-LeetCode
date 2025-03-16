class Solution {
    public boolean check(int[] ranks, int cars, long minGiven) {
        long temp = 0;
        for (int r : ranks) {
            long c2 = minGiven / r;
            long c = (long) Math.sqrt(c2);
            temp += c;
        }
        return temp >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        long l = 1, r = (long) 1e14;
        while (l < r) {
            long mid = (l + r) / 2;
            if (check(ranks, cars, mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}