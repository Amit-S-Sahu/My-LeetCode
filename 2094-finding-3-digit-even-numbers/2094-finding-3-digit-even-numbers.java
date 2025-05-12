class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int map[] = new int[10];
        for (int d : digits) map[d]++;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (map[i] == 0) continue;
            map[i]--;
            for (int j = 0; j <= 9; j++) {
                if (map[j] == 0) continue;
                map[j]--;
                for (int k = 0; k <= 8; k += 2) {
                    if (map[k] == 0) continue;
                    res.add(i*100 + j*10 + k);
                }
                map[j]++;
            }
            map[i]++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}