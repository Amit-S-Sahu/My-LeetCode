class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String s1Words[] = s1.split(" ");
        for (String word : s1Words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String s2Words[] = s2.split(" ");
        for (String word : s2Words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            if (map.get(word) == 1) ans.add(word);
        }

        return ans.toArray(new String[0]);
    }
}