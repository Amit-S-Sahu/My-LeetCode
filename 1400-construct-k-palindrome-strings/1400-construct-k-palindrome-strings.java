class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int odd = 0;
        for (Character ch : map.keySet()) {
            if (map.get(ch) % 2 != 0) odd++;
        }

        if (odd > k) return false;
        return true;
    }
}