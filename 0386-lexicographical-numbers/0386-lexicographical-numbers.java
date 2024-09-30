class Solution {
    public List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        recursiveTrie(0, n);
        return ans;
    }

    public void recursiveTrie(int node, int n) {
        for (int i = node; i <= Math.min(node + 9, n); i++) {
            if (i == 0) continue;
            ans.add(i);
            if (i * 10 <= n) recursiveTrie(i * 10, n);
        }
    }
}