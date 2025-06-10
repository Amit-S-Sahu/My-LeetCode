class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int max = 0, min = s.length();
        for (char ch : map.keySet()) {
            int temp = map.get(ch);
            if (temp % 2 != 0) max = Math.max(max, temp);
            if (temp % 2 == 0 && temp > 0) min = Math.min(min, temp);
        }
        return max - min;
    }
}