class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int n1 = Integer.parseInt(s.pop());
                int n2 = Integer.parseInt(s.pop());
                n1 += n2;
                s.push(String.valueOf(n1));
            }
            else if (token.equals("-")) {
                int n1 = Integer.parseInt(s.pop());
                int n2 = Integer.parseInt(s.pop());
                n2 -= n1;
                s.push(String.valueOf(n2));
            }
            else if (token.equals("*")) {
                int n1 = Integer.parseInt(s.pop());
                int n2 = Integer.parseInt(s.pop());
                n1 *= n2;
                s.push(String.valueOf(n1));
            }
            else if (token.equals("/")) {
                int n1 = Integer.parseInt(s.pop());
                int n2 = Integer.parseInt(s.pop());
                n2 /= n1;
                s.push(String.valueOf(n2));
            }
            else s.push(token);
        }
        return Integer.parseInt(s.pop());
    }
}