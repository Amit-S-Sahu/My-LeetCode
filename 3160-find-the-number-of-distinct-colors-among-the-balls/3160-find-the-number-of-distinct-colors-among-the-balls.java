class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> ball = new HashMap<>(), color = new HashMap<>();
        int n = queries.length, distinct = 0;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++){
            int pos = queries[i][0], c = queries[i][1];
            if(ball.containsKey(pos)){
                int count = color.get(ball.get(pos)) - 1;
                if(count == 0){ 
                    color.remove(ball.get(pos)); 
                    distinct--; 
                }
                else color.put(ball.get(pos), count);
            }
            ball.put(pos, c);
            int count = color.getOrDefault(c, 0) + 1;
            color.put(c, count);
            if(count == 1) distinct++;
            ans[i] = distinct;
        }
        return ans;
    }
}