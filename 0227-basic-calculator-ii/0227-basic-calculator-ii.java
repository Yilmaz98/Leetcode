class Solution {
    public int precedence(char op) {
        if(op == '/' || op == '*')
            return 2;
        else if (op == '+' || op == '-') 
            return 1;
         else 
            return 0;
    }
    
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int ans = 0;
        
        for(int i=0;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                int result = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    result = result * 10 + s.charAt(i) - '0';
                    i++;
                }
                nums.add(result);
                i--;
            } else if(s.charAt(i) == '(') {
                ops.add(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                while(ops.peek() != '(') {
                    nums.add(calculate(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
            if(s.charAt(i) == '-') {
                if(nums.isEmpty() || !ops.isEmpty() && ops.peek() == '(') {
                    nums.add(0);
                }
            }
            while(!ops.isEmpty() && precedence(ops.peek()) >= precedence(s.charAt(i))) {
                nums.add(calculate(ops.pop(), nums.pop(), nums.pop()));
            }
            ops.add(s.charAt(i));
            }
        }
        
        while(!ops.isEmpty()) {
            nums.add(calculate(ops.pop(), nums.pop(), nums.pop()));
        }
        
        return nums.pop();
    }
    
    public int calculate(char op, int b, int a) {
        switch(op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
        }
        return -1;
    }
}