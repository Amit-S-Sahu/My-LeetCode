class Solution {
    int ST[];
    int n;

    private void build(int arr[], int node, int left, int right) {
        if (left == right) {
            ST[node] = arr[left];
            return;
        }
        int mid = left + (right - left) / 2;
        build(arr, node << 1, left, mid);
        build(arr, node << 1 | 1, mid + 1, right);
        ST[node] = Math.min(ST[2 * node], ST[2 * node + 1]);
    }

    private int query(int node, int tl, int tr, int left, int right) {
        if (right < tl || tr < left) return Integer.MAX_VALUE;
        if (left <= tl && tr <= right) return ST[node];
        int tm = (tl + tr) >>> 1;
        return Math.min(query(2 * node, tl, tm, left, right), query(2 * node + 1, tm + 1, tr, left, right));
    }

    private int helper(int arr[], int curr, int left, int right) {
        if (left > right) return 0;
        if (left == right) return arr[left] - curr;

        int min = query(1, 0, n - 1, left, right);
        int res = min - curr;

        int i = left;
        while (i <= right) {
            if (arr[i] > min) {
                int j = i;
                while (j + 1 <= right && arr[j + 1] > min) j++;
                res += helper(arr, min, i, j);
                i = j + 1;
            } 
            else i++;
        }
        return res;
    }

    public int minNumberOperations(int[] target) {
        n = target.length;
        ST = new int[4 * n];
        build(target, 1, 0, n - 1);
        return helper(target, 0, 0, n - 1);
    }
}
