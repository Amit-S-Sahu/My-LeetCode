class Solution {
    public boolean isValid(String str) {
        if (str.length() % 2 != 0) return false;
        Stack<Character> s = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            } else {
                if (s.isEmpty()) return false;
                if (ch == ')' && s.peek() == '(') s.pop();
                else if (ch == ']' && s.peek() == '[') s.pop();
                else if (ch == '}' && s.peek() == '{') s.pop();
                else return false;
            }
        }

        return s.isEmpty();
    }
}
