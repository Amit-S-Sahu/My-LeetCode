class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int curr = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int item[] : items) {
            if (item[1] <= curr) continue;
            curr = item[1];
            map.put(item[0], curr);
        }

        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(queries[i]);
            if (entry != null) ans[i] = entry.getValue();   
        }
        return ans;
    }
}