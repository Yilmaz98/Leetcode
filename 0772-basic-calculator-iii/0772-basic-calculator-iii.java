class Solution {
    public int calculate(String s) {
        if(s.length() == 0 || s == null) return 0;
        
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int operand = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                operand = (ch - '0');
                while(i + 1< s.length() && Character.isDigit(s.charAt(i+1))) {
                    operand = (operand*10) + (s.charAt(i+1) - '0');
                    i++;
                }
                nums.push(operand);
                operand = 0;
            } 
            else if(ch == '(') {
                ops.push(ch);
            } else if(ch == ')') {
                while(ops.peek() != '(') {
                    nums.push(operation(nums.pop(), ops.pop(), nums.pop()));
                }
                ops.pop();
            } else if(ch == '+' || ch == '-' || ch == '*' || ch =='/') {
                while(!ops.isEmpty() && hasPrecedence(ops.peek(), ch)) {
                    nums.push(operation(nums.pop(), ops.pop(), nums.pop()));
                }
                ops.push(ch);
            }
        }
        
        while(!ops.isEmpty())
        {
            nums.push(operation(nums.pop(), ops.pop(), nums.pop()));
        }
        
        return nums.pop();
    }
    
    public int operation(int a, char op, int b) {
        switch(op) {
            case '+': return b + a;
            case '-': return b - a;
            case '*': return b * a;
            case '/': return b / a;
        }
        return 0;
    }
    
    public boolean hasPrecedence(char op1, char op2) {
        if(op1 == '(' || op1 == ')')
            return false;
        
        if((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) {
            return false;
        }
        
        return true;
    }
}