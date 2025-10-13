class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = "";

        for (String w : words) {
            char ch[] = w.toCharArray();
            Arrays.sort(ch);
            String sig = new String(ch);
            if (!sig.equals(prev)) {
                ans.add(w);
                prev = sig;
            }
        }
        return ans;
    }
}