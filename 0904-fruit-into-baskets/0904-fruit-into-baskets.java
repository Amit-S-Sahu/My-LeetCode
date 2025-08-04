class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n <= 2) return n;
        int start = 0, end = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(end < n) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            while(map.size() >= 3) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if(map.get(fruits[start]) == 0) map.remove(fruits[start]);
                start++;
            }
            int curr = end - start + 1;
            max = Math.max(max, curr);
            end++;
        }
        return max;
    }
}