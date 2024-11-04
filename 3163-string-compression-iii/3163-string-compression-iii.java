class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int count = 1;

        while (i < word.length() - 1) {
            char prev = word.charAt(i);
            char curr = word.charAt(i + 1);

            if (prev == curr) {
                count++;
                if (count == 9) { 
                    sb.append("9").append(prev);
                    count = 0;
                }
            } 
            else {
                if (count > 0) sb.append(count).append(prev);
                count = 1;
            }
            i++;
        }

        if (count > 0) sb.append(count).append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}
