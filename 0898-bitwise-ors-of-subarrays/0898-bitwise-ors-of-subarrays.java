class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        for (int x : arr) {
            HashSet<Integer> curr = new HashSet<>();
            curr.add(x);
            for (int y : prev) curr.add(x | y);
            res.addAll(curr);
            prev = curr;
        }
        return res.size();
    }
}
