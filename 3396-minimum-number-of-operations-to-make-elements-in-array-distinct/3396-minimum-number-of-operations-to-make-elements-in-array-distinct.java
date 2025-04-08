class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0, temp;
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        while (true) {
            HashMap<Integer, Integer> map = new HashMap<>();
            temp = 0;
            for (int num : list)
                if (map.put(num, map.getOrDefault(num, 0) + 1) != null && map.get(num) == 2) temp++;
            if (temp == 0) break;
            int remove = Math.min(3, list.size());
            for (int i = 0; i < remove; i++) list.remove(0);
            count++;
        }
        return count;
    }
}