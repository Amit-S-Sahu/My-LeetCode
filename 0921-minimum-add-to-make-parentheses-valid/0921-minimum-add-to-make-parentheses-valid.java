class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            }
            else if(s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(')');
            }
            i++;
        }
        return stack.size();   
    }
}