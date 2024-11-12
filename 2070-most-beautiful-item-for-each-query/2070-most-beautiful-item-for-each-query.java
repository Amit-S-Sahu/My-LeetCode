class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < items.length; i++) {
            map.put(items[i][0], Math.max(map.getOrDefault(items[i][0], 0), items[i][1]));
        }
        
        TreeMap<Integer, Integer> sorted = new TreeMap<>();

        for (int key : map.keySet()) sorted.put(key, map.get(key));

        int prev = 0, c = 0;
        int arr[] = new int[sorted.size()];
        int res[] = new int[queries.length];

        for (int key : sorted.keySet()) {
            sorted.put(key, Math.max(sorted.get(key), prev));
            prev = sorted.get(key);
            arr[c++] = key;
        }
        
        for (int i = 0; i < queries.length; i++) {
            Integer val = sorted.get(queries[i]);
            if (val == null) {
                Integer higherKey = sorted.lowerKey(queries[i]);
                val = higherKey == null ? 0 : sorted.get(higherKey);
            }
            res[i] = val;
        }
        return res;
    }
}