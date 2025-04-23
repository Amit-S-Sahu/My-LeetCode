class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, count = 0;

        for (int i = 1; i <= n; i++) {
            int x = digsum(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
            max = Math.max(max, map.get(x));
        }

        for (int val : map.values()) if (val == max) count++;
        return count;
    }

    private int digsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}