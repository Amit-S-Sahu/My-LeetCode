class Solution {
        private int dfs(HashMap<Character, Integer> map) {
        int sum = 0;
        for (char key : map.keySet()) {
            if (map.get(key) > 0) {
                sum++; 
                map.put(key, map.get(key) - 1);
                sum += dfs(map);
                map.put(key, map.get(key) + 1);
            }
        }
        return sum;
    }
    
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tiles.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return dfs(map);
    }
}
