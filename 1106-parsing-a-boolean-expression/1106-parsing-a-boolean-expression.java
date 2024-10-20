class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operator = new Stack<>();
        Stack<Character> operands = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            
            if (curr == '!' || curr == '&' || curr == '|') operator.push(curr);  
            else if (curr == '(') operands.push(curr);  
            else if (curr == 'f') operands.push('0');   
            else if (curr == 't') operands.push('1');   
            else if (curr == ')') {
                char op = operator.pop();
                int res = (operands.pop() - '0');  
                
                while (operands.peek() != '(') {
                    if (op == '&') res &= (operands.pop() - '0');  
                    else if (op == '|') res |= (operands.pop() - '0');
                }
                operands.pop();
                if (op == '!') res = res == 1 ? 0 : 1;
                operands.push((char)(res + '0'));
            }
        }
        return operands.pop() == '1';
    }
}
