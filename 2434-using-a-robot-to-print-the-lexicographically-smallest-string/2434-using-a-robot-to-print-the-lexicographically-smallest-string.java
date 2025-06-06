class Solution {
    public String robotWithString(String s) {
        int chars[] = new int[26];
        for (char c : s.toCharArray()) chars[c - 'a']++;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char minChar = 'a';
        for (char ch : s.toCharArray()) {
            stack.push(ch);
            chars[ch - 'a']--;
            while (minChar != 'z' && chars[minChar - 'a'] == 0) {
                minChar++;
            }
            while (!stack.isEmpty() && stack.peek() <= minChar) {
                sb.append(stack.pop());
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}