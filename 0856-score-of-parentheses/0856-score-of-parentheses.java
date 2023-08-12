class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                st.push(0);
            } else {
                int u = st.pop();
                int v = st.pop();
                
                st.push(v + Math.max(2 * u, 1));
            }    
            
            //System.out.println(st);
        }
        
        return st.pop();
    }
}