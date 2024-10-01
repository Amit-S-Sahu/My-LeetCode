class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> ans = new HashSet<>();

        for (String s : bannedWords) {
            ans.add(s);
        }

        int count = 0;
        for (String s : message) {
            if (ans.contains(s)) count++;
            if (count == 2) return true;
        }

        return false;
    }
}