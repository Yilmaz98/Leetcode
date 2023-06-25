class Solution {
    public int calculate(String s) {
        
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> opStack = new LinkedList<>();
        
        int result = 0;
        
        for(int i = 0;i< s.length(); i++) {
            char c  = s.charAt(i);
            
            if(Character.isDigit(c)) {
                int val = c-'0';
                
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    val = val * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                
            numStack.addLast(val);
            if(!opStack.isEmpty()) {
                char prevOp = opStack.peekLast();
                if(prevOp == '*' || prevOp == '/') {
                                     
                    int num1 = numStack.pollLast();
                    int num2 = numStack.pollLast();
  
                    opStack.pollLast();
                    if(prevOp == '*')
                        numStack.addLast(num2 * num1);
                    else 
                        numStack.addLast(num2 / num1);
                } 
            }
                
            } else if(c == '+' || c == '-' || c == '*' || c == '/') {
                opStack.addLast(c);
            }
        }  
        
        while(!numStack.isEmpty() && !opStack.isEmpty()) {
            int num1 = numStack.pollFirst();
            int num2 = numStack.pollFirst();
            char op = opStack.pollFirst();
            
            if(op == '+') {
                numStack.addFirst(num1 + num2);
            } else {
                numStack.addFirst(num1 - num2);
            }
        }
        
        while(!numStack.isEmpty()) {
            result += numStack.pollFirst();
        }
        
        
        return result;
    }
}