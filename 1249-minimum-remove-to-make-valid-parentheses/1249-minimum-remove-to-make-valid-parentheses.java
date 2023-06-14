class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> removal = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(')
                st.push(i);
            
            if(s.charAt(i) == ')') {
                if(st.isEmpty()) {
                    removal.add(i);
                } else {
                    st.pop();
                }
            }
        }
        
        while(!st.isEmpty()) {
            removal.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            if(removal.contains(i))
                continue;
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}