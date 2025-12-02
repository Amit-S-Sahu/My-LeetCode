class Solution {
    public int countTrapezoids(int[][] points) {
        long mod = 1000000007L;
        Map<Integer,Long> map = new HashMap<>();
        for(int point[] : points){
            map.put(point[1], map.getOrDefault(point[1], 0L) + 1);
        }
        List<Long> height = new ArrayList<>();
        for(long val : map.values()) {
            if (val >= 2) {
                long ways = (val * (val - 1)) / 2;
                height.add(ways % mod);
            }
        }
        long ans = 0,sum = 0;
        for(long val : height){
            ans = (ans + (val * sum) % mod) % mod;
            sum = (sum + val) % mod;
        }
        return (int)ans;
    }
}