class Solution {
    private boolean sorted(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) if (arr.get(i) > arr.get(i + 1)) return false;
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        int ans = 0;
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) arr.add(num);
        while (!sorted(arr)) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int i = 1; i < arr.size(); i++) {
                int curr = arr.get(i - 1) + arr.get(i);
                if (curr < min) {
                    min = curr;
                    k = i;
                }
            }
            arr.remove(k);
            arr.remove(k - 1);
            arr.add(k - 1, min);
            ans++;
        }
        return ans;
    }
}