class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int ans[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            set.add(B[i]);
            ans[i] = 2 * (i + 1) - set.size();
        }

        return ans;
    }
}