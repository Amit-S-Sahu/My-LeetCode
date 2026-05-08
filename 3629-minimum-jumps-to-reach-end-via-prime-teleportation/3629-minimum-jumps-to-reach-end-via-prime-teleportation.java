class Solution {

    static int max = 1000001;
    static List<Integer>[] factors = new ArrayList[max];

    static {
        for (int i = 0; i < max; i++) factors[i] = new ArrayList<>();
        for (int i = 2; i < max; i++) {
            if (factors[i].isEmpty()) {
                for (int j = i; j < max; j += i) factors[j].add(i);
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int p : factors[nums[i]]) {
                edges.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }
        int ans = 0;
        boolean visited[] = new boolean[n];
        visited[0] = true;
        List<Integer> q = new ArrayList<>();
        q.add(0);
        while (true) {
            List<Integer> q2 = new ArrayList<>();
            for (int i : q) {
                if (i == n - 1) return ans;
                if (i > 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q2.add(i - 1);
                }
                if (i < n - 1 && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q2.add(i + 1);
                }
                if (factors[nums[i]].size() == 1) {
                    int p = nums[i];
                    if (edges.containsKey(p)) {
                        for (int j : edges.get(p)) {
                            if (!visited[j]) {
                                visited[j] = true;
                                q2.add(j);
                            }
                        }
                        edges.get(p).clear();
                    }
                }
            }
            q = q2;
            ans++;
        }
    }
}