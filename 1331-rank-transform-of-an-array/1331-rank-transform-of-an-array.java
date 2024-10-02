class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        for (int i=0;i<arr.length;i++) {
            map.putIfAbsent(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
        
        int rank = 1;
        while (!map.isEmpty()) {
            Map.Entry<Integer, List<Integer>> entry = map.pollFirstEntry();
            for (int index : entry.getValue()) arr[index] = rank;
            rank++;
        }
        return arr;
    }
}