class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int n = word.length();
        int req = n - numFriends + 1;
        String ans = "";
        for (int i = 0; i < n; i++) {
            String temp = word.substring(i, Math.min(i + req, n));
            if (ans.compareTo(temp) <= 0) ans = temp;
        }

        return ans;
    }
}