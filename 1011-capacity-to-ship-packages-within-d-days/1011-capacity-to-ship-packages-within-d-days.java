class Solution {
        public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2, need = 1, curr = 0;
            for (int weight : weights) {
                if (curr + weight > mid) {
                    need += 1;
                    curr = 0;
                }
                curr += weight;
            }
            if (need > days) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}