class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        char operation = '+';
        int currentNumber = 0;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ' ' && i!=s.length()-1)
                continue;
            
            if(Character.isDigit(s.charAt(i))) {
                currentNumber = currentNumber *10 + (s.charAt(i)-'0');
            }
            
            if(!Character.isDigit(s.charAt(i)) || i == s.length() - 1){
                if(operation == '+') {
                    st.push(currentNumber);
                } else if(operation == '-') {
                    st.push(-currentNumber);
                }
                else if(operation == '*') {
                    st.push(st.pop() * currentNumber);
                } else if(operation  == '/') {
                    st.push(st.pop() / currentNumber);
                }
                
                operation = s.charAt(i);
                currentNumber = 0;
            }
        }
        int result = 0;
        while(!st.isEmpty()) {
            result += st.pop();
        }
        
        return result;
    }
}