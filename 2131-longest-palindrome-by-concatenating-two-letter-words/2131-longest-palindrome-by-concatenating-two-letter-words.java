class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        int count = 0, alreadyPalindrome = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String w = e.getKey();
            int freq = e.getValue();
            String s = new StringBuilder(w).reverse().toString();
            if (w.equals(s)) {
                count += (freq / 2) * 4;
                if (freq % 2 == 1) alreadyPalindrome = 1;
            } 
            else if (w.compareTo(s) < 0 && map.containsKey(s)) count += Math.min(freq, map.get(s)) * 4;
        }
        return count + alreadyPalindrome * 2;
    }
}