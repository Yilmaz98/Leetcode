class Solution {
    public Map<Character, Integer> precedenceMap() {
        Map<Character, Integer> m = new HashMap<>();
        m.put('+', 1);
        m.put('-', 1);
        m.put('*',2);
        m.put('/',2);
        m.put('(',0);
        
        return m;
        
    }
    
    public int applyOp(char op, int b, int a) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        
        return Integer.MIN_VALUE;
    }
    
    public int calculate(String s) {
        char[] tokens = s.toCharArray();
        
        Map<Character, Integer> m = precedenceMap();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        
        for(int i=0;i<tokens.length;i++) {
            char c = tokens[i];
            
            if(Character.isDigit(c)) {
                int num = 0;
                while(i < tokens.length && Character.isDigit(tokens[i])) {
                    num = num * 10 + (tokens[i]  - '0');
                    i++;
                }
                nums.add(num);
                i--;
            }
            else if(c == '(') {
                ops.push(c);
            } else if(c == ')') {
                while(ops.peek() != '(') {
                    nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else {
                while(!ops.isEmpty() && m.get(c) <= m.get(ops.peek()))
                    nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                    
                ops.push(c);
            }
        }
        
        while(!ops.isEmpty()) {
             nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
        }
        
        return nums.pop();
    }
}