class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>(Arrays.asList('b', 'a', 'l', 'o', 'n'));

        for (Character ch : text.toCharArray()) {
            if (set.contains(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        map.put('l', map.getOrDefault('l', 0) / 2);
        map.put('o', map.getOrDefault('o', 0) / 2);

        int min = map.getOrDefault('b', 0);
        for (Character ch : set) {
            if (map.getOrDefault(ch, 0) <= min) min = map.getOrDefault(ch, 0);
        }

        return min;
    }
}