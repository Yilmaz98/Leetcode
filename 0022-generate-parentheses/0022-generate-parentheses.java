class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int open = n, closed = n;
        generate(open, closed, new StringBuilder());
        return result;
    }
    
    public boolean checkString(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                st.add(s.charAt(i));
            } else {
                if(st.isEmpty())
                    return false;
                else {
                    if(st.peek() == ')')
                        return false;
                    else 
                         st.pop();
                }
               
            }
        }
        return true;
    }
    
    public void generate(int open, int closed, StringBuilder sb) {
        if(open == 0 && closed == 0) {

            boolean valid = checkString(sb.toString());
            if(valid) {
                result.add(sb.toString());
                return;
            }
        }
        
        if(open < 0 || closed < 0) {
            return;
        }
        
        sb.append("(");
        generate(open-1, closed, sb);
        if(sb.length() != 0)
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        generate(open, closed - 1, sb);
        if(sb.length() != 0)
        sb.deleteCharAt(sb.length()-1);
    }
    
}