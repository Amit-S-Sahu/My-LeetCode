class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i]) && !seen.contains(words[i])) {
                    ans.add(words[i]);
                    seen.add(words[i]);
                }
                if (words[i].contains(words[j]) && !seen.contains(words[j])) {
                    ans.add(words[j]);
                    seen.add(words[j]);
                }
            }
        }

        return ans;
    }
}
