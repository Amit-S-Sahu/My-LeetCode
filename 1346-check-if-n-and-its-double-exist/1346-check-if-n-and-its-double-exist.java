class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap();

        for (int num : arr) {
            if (map.containsKey(num * 2)) return true;
            else if (num % 2 == 0 && map.containsKey(num / 2)) return true;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }
}