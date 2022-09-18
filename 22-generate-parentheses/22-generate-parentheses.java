class Solution {
    public List<String> generateParenthesis(int n) {
        int openN = 0;
        int closedN = 0;
        
        List<String> result = new ArrayList<>();
        
        generate(openN,closedN, result,n, "");
        
        return result;
    }
    
    public boolean wellFormed(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(')
                st.push(s.charAt(i));
            
            if(s.charAt(i) == ')') {
                if(st.isEmpty()) {
                    return false;
                }
                
                if(st.peek()!='(')
                    return false;
                
                st.pop();
            }
        }
        
        return true;
        
    }
    
    public void generate(int o, int c, List<String> result, int n, String curr) {
        
        if(o == n && c == n ) {
            if(wellFormed(curr))
                result.add(curr);
            return;
        }
        
        if(o < n) {
            generate(o+1,c,result, n, curr + "(");
        }
        
         if(c < n) {
            generate(o,c+1,result, n, curr + ")");
        }
        
        return;
    }
}