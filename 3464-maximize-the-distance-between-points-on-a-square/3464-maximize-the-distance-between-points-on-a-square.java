class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        List<Long> list = new ArrayList<>();

        for (int point[] : points) {
            int x = point[0];
            int y = point[1];
            if (x == 0) list.add((long) y);
            else if (y == side) list.add((long) side + x);
            else if (x == side) list.add(side * 3L - y);
            else list.add(side * 4L - x);
        }
        Collections.sort(list);

        long left = 1;
        long right = side;
        int ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(list, side, k, mid)) {
                left = mid + 1;
                ans = (int) mid;
            } 
            else right = mid - 1;
        }
        return ans;
    }

    private boolean check(List<Long> list, int side, int k, long limit) {
        long perimeter = side * 4L;
        for (long start : list) {
            long end = start + perimeter - limit;
            long cur = start;

            for (int i = 0; i < k - 1; i++) {
                int idx = lowerBound(list, cur + limit);
                if (idx == list.size() || list.get(idx) > end) {
                    cur = -1;
                    break;
                }
                cur = list.get(idx);
            }

            if (cur >= 0) return true;
        }
        return false;
    }

    private int lowerBound(List<Long> list, long target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}