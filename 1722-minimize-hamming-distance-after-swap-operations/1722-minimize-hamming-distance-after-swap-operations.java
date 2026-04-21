class Solution {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xPar = find(x);
            int yPar = find(y);
            if (xPar == yPar) return;
            if (rank[xPar] > rank[yPar]) parent[yPar] = xPar;
            else if (rank[xPar] < rank[yPar]) parent[xPar] = yPar;
            else {
                parent[xPar] = yPar;
                rank[yPar]++;
            }
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        DSU dsu = new DSU(source.length);
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int key = dsu.find(i);
            map.computeIfAbsent(key, k -> new HashMap<Integer, Integer>());
            Map<Integer, Integer> freq = map.get(key);
            if (freq.containsKey(source[i])) freq.put(source[i], freq.get(source[i]) + 1);
            else freq.put(source[i], 1);
        }

        int ans = 0;
        for (int i = 0; i < source.length; i++) {
            HashMap<Integer, Integer> freq = map.get(dsu.find(i));
            if (freq == null) {
                if (source[i] != target[i]) ans++;
                continue;
            }
            Integer count = freq.get(target[i]);

            if (count != null && count != 0) freq.put(target[i], count - 1);
            else {
                if (count != null && count == 0) freq.remove(target[i]);
                ans++;
            }
        }
        return ans;
    }
}