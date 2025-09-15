class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String words[] = text.split(" ");
        int ans = words.length;
        for (String word : words) {
            for (char ch : brokenLetters.toCharArray()) {
                if (word.indexOf(ch) != -1) {
                    ans--;
                    break;
                }
            }
        }

        return ans;
    }
}