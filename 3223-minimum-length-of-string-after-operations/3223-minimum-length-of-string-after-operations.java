class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
        for (Character ch : map.keySet()) {
            while (map.get(ch) >= 3) {
                n -= 2;
                map.put(ch, map.get(ch) - 2);
            }
        }

        return n;
    }
}