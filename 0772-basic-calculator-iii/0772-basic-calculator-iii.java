/*
We evaluate expressions from the left to the right. When we see two adjacent operators,
we can't do the first operation directly unless the precedence of the second operation is equal to
or less than the first operator.
*/

class Solution {
    Map<Character, Integer> precedence;
    
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(', 0); // !!
        
        return evalExpression(s);
    }
                       
    private int evalExpression(String s) {
        // Assert s is valid  
        Stack<Character> ops = new Stack<>();
        Stack<Integer> values = new Stack<>();
        
        char[] tokens = s.toCharArray();
        char pre = ' ';
        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i];
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < tokens.length && Character.isDigit(tokens[i]))
                     num = 10*num + tokens[i++] - '0';
                values.push(num);
                i--;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();  // pop out '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Dealing with the negative number
                if (i == 0 && c == '-') {
                    values.push(0);
                } else if (pre == '(' && c == '-') {
                    values.push(0);
                }
                
                // While top of 'ops' has same or greater precedence to current 
                // token, which is an operator. Apply operator on top of 'ops' 
                // to top two elements in values stack 
                while (!ops.isEmpty() && precedence.get(c) <= precedence.get(ops.peek())) 
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                ops.push(c);
            }
            pre = c;
        }
        
        while (!ops.isEmpty()) 
             values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        
       return values.pop();
    }
                       
    private int applyOp(Character op, int b, int a) { // b is before a (!!)
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': {
                assert b != 0;
                return a / b;
            }
        }
        return Integer.MIN_VALUE;
    }
}