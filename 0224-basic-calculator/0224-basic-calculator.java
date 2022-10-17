class Solution {
    public int calculate(String s) {
        int result = 0;
        int operand = 0;
        int sign = 1;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                operand = operand * 10 + (ch - '0');
            } 
            else if(ch == '+') {
                result += sign * operand;
                operand = 0;
                sign = 1;
            } else if(ch == '-') {
                result += sign * operand;
                operand = 0;
                sign = -1;
            } else if(ch == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            } else if(ch == ')') {
                result += sign*operand;
                result *= st.pop();
                result += st.pop();
                operand = 0;
            }
        }
        
        return result + (sign * operand);
    }
}