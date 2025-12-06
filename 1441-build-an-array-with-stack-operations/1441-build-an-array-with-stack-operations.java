class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            list.add("Push");
            if (j < target.length && i != target[j]) list.add("Pop");
            else j++;
            if (j == target.length) break;
        }

        return list;
    }
}